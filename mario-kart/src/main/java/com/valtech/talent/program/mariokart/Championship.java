package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.*;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.DriverCategory.M;
import static com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.DriverCategory.valueOf;

public class Championship {

    public static final String DRIVERS_TXT = "/drivers.txt";

    public Collection<Driver> loadDrivers() {
        return getFileContent()
                .stream()
                .filter(this::validateLine)
                .map(s -> s.split(";"))
                .map(this::mapDriver)
                //.peek(System.out::println)
                .collect(Collectors.toList());
    }

    private List<String> getFileContent() {
        try {
            return IOUtils.readLines(this.getClass().getResourceAsStream(DRIVERS_TXT), StandardCharsets.UTF_8);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Driver mapDriver(String[] arr){
        return new Driver(arr[0], arr.length > 1? valueOf(arr[1]): M);
    }

    private boolean validateLine(String line){
        return !line.isBlank()
                && Pattern.matches("[a-zA-Z; \\.]*", line);

    }

    public Collection<Driver> qualifications(Collection<Driver> drivers, Circuit circuit) {
        return drivers.stream()
                .map(d -> computePerformance(d,circuit))
                .sorted(Comparator.comparingDouble(Performance::getTimeInSeconds))
                //.peek(p -> System.out.println("PERF :"+p.driver +p.timeInSeconds))
                .limit(10)
                .map(Performance::getDriver)
                .collect(Collectors.toList());

    }





    private Performance computePerformance(Driver driver, Circuit circuit){
        return new Performance(driver, circuit.perform(driver.getCategory()));
    }


    public Collection<Performance> race(Collection<Driver> drivers, Circuit circuit) {
        return drivers.stream()
                .map(d -> computePerformance(d,circuit))
                .collect(Collectors.toList());
    }

    public Map<Circuit, Collection<Performance>> perform(Collection<Driver> drivers) {

         return Stream.of(Circuit.values())
                 .map(circuit -> new CircuitQualif(circuit, qualifications(drivers, circuit)))
                 .collect(Collectors.toMap(
                         CircuitQualif::getCircuit, // key
                         (cq) -> this.race(cq.getQualified(), cq.getCircuit()))); // value

    }

    public Collection<PointsPerDriver> computeRacePoints(Collection<Performance> raceResults) {


        ArrayList<Performance> asList = new ArrayList<>(raceResults);

        return IntStream.range(0, raceResults.size())
                .mapToObj(index -> new PointsPerDriver(asList.get(index).getDriver(),10 - index))
                .collect(Collectors.toList());
    }

    public Collection<PointsPerDriver> computeChampionshipPoints(Map<Circuit, Collection<Performance>> championshipResults) {
        return championshipResults.values().stream()
                .map(this::computeRacePoints)
                .reduce(this::mergeResults)
                .orElseThrow(() -> new RuntimeException("No results"))
                .stream().sorted(Comparator.comparing(PointsPerDriver::getPoints).reversed())
                .collect(Collectors.toList());
    }

    public Collection<PointsPerDriver> mergeResults(Collection<PointsPerDriver> first, Collection<PointsPerDriver>  second){

        return Stream.concat(first.stream(), second.stream())
                .collect(
                        () -> new HashMap<Driver, Integer>(),
                        (accMap, pointsPerDriver) -> Optional
                                .ofNullable(accMap.get(pointsPerDriver.getDriver()))
                                .ifPresentOrElse(
                                        v -> accMap.put(pointsPerDriver.getDriver(), v + pointsPerDriver.getPoints()),
                                        () -> accMap.put(pointsPerDriver.getDriver(), pointsPerDriver.getPoints())), (map, map2) -> {
                        }).entrySet()
                        .stream()
                        .map(e -> new PointsPerDriver(e.getKey(), e.getValue()))
                        .collect(Collectors.toList());


    }
}
