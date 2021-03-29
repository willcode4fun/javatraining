package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.driver.JpaDriverRepository;
import com.valtech.talent.program.mariokart.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChampionshipService {

    private final JpaDriverRepository driverRepository;


    public Collection<Driver> qualifications(Circuit circuit) {

        return driverRepository.loadDrivers().stream()
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

    public Map<Circuit, Collection<Performance>> perform() {

         return Stream.of(Circuit.values())
                 .map(circuit -> new CircuitQualif(circuit, qualifications( circuit)))
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

    private Collection<PointsPerDriver> mergeResults(Collection<PointsPerDriver> first, Collection<PointsPerDriver>  second){

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
