package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Circuit;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Driver;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Performance;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.PointsPerDriver;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

import org.assertj.core.api.Assertions;

public class ChampionshipTest {

    @Test
    public void should_load_drivers(){
        Championship championship = new Championship();

        Collection<Driver> drivers = championship.loadDrivers();

        Assertions.assertThat(drivers)
                .isNotEmpty()
                .hasSize(41);
    }

    @Test
    public void should_perform_qualifications(){
        Championship championship = new Championship();
        Collection<Driver> drivers = championship.loadDrivers();

        Collection<Driver> qualified = championship.qualifications(drivers, Circuit.BOWSER_CASLE);

        Assertions.assertThat(qualified)
                .isNotEmpty()
                .hasSize(10);
    }

    @Test
    public void should_perform_race(){
        Championship championship = new Championship();
        Collection<Driver> drivers = championship.loadDrivers();

        Collection<Driver> qualified = championship.qualifications(drivers, Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championship.race(qualified, Circuit.BOWSER_CASLE);

        Assertions.assertThat(raceResults)
                .isNotEmpty()
                .hasSize(10);
    }

    @Test
    public void should_perform_championship(){
        Championship championship = new Championship();
        Collection<Driver> drivers = championship.loadDrivers();

        Map<Circuit, Collection<Performance>> championshipResults = championship.perform(drivers);

        Assertions.assertThat(championshipResults)
                .isNotEmpty()
                .hasSize(4);
    }

    @Test
    public void should_compute_race_points(){
        Championship championship = new Championship();
        Collection<Driver> drivers = championship.loadDrivers();
        Collection<Driver> qualified = championship.qualifications(drivers, Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championship.race(qualified, Circuit.BOWSER_CASLE);

        Collection<PointsPerDriver> pointsPerDriver = championship.computeRacePoints(raceResults);

        Assertions.assertThat(pointsPerDriver)
                .isNotEmpty()
                .hasSize(10);

    }


    @Test
    public void should_compute_championship_points(){
        Championship championship = new Championship();
        Collection<Driver> drivers = championship.loadDrivers();
        Map<Circuit, Collection<Performance>> championshipResults = championship.perform(drivers);

        Collection<PointsPerDriver> pointsPerDriver = championship.computeChampionshipPoints(championshipResults);


        pointsPerDriver.stream().forEach(ppdriver -> System.out.println("Driver : "+ppdriver.getDriver().getName()+" points "+ppdriver.getPoints()));
    }

}