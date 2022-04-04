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
        //TODO: Task 2.1
        return Collections.emptyList();

    }

    private Performance computePerformance(Driver driver, Circuit circuit){
        //TODO use Circuit.perform
        return new Performance(driver, circuit.perform(driver.getCategory()));
    }


    public Collection<Performance> race(Collection<Driver> drivers, Circuit circuit) {
        //TODO: Task 2.2
        return Collections.emptyList();
    }

    public Collection<PointsPerDriver> computeRacePoints(Collection<Performance> raceResults) {

        //TODO: Task 3.1

        // TODO: Task 3.2

        return Collections.emptyList();
    }

    public Map<Circuit, Collection<Performance>> performChampionship() {

         return Stream.of(Circuit.values())
                 .map(circuit -> new CircuitQualif(circuit, qualifications( circuit)))
                 .collect(Collectors.toMap(
                         CircuitQualif::getCircuit, // key
                         (cq) -> this.race(cq.getQualified(), cq.getCircuit()))); // value

    }



    public Collection<PointsPerDriver> computeChampionshipPoints(Map<Circuit, Collection<Performance>> championshipResults) {
        // TODO: Task 3.3

        return Collections.emptyList();
    }

    private Collection<PointsPerDriver> mergeResults(Collection<PointsPerDriver> first, Collection<PointsPerDriver>  second){

        return Collections.emptyList();


    }


}
