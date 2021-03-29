package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Circuit;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Driver;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Performance;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.PointsPerDriver;
import com.valtech.talent.program.mariokart.driver.ExcelDriverRepository;
import com.valtech.talent.program.mariokart.driver.TextDriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;
import java.util.Collection;
import java.util.Map;

@Slf4j
public class ChampionshipTest {


    @Test
    public void should_load_drivers(){
        TextDriverRepository textDriverRepository = new TextDriverRepository();

        Collection<Driver> drivers = textDriverRepository.loadDrivers();

        Assertions.assertThat(drivers)
                .isNotEmpty()
                .hasSize(41);
    }

    @Test
    public void should_load_drivers_from_excel_file(){

        Collection<Driver> drivers = new ExcelDriverRepository().loadDrivers();

        Assertions.assertThat(drivers)
                .isNotEmpty()
                .hasSize(41);
    }

    @Test
    public void should_perform_qualifications(){
        Championship championship = new Championship();
        Collection<Driver> drivers = new TextDriverRepository().loadDrivers();

        Collection<Driver> qualified = championship.qualifications(drivers, Circuit.BOWSER_CASLE);

        Assertions.assertThat(qualified)
                .isNotEmpty()
                .hasSize(10);
    }

    @Test
    public void should_perform_race(){
        Championship championship = new Championship();
        Collection<Driver> drivers = new TextDriverRepository().loadDrivers();

        Collection<Driver> qualified = championship.qualifications(drivers, Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championship.race(qualified, Circuit.BOWSER_CASLE);

        Assertions.assertThat(raceResults)
                .isNotEmpty()
                .hasSize(10);
    }

    @Test
    public void should_export_race_results(){
        Championship championship = new Championship();
        Collection<Driver> drivers = new TextDriverRepository().loadDrivers();

        Collection<Driver> qualified = championship.qualifications(drivers, Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championship.race(qualified, Circuit.BOWSER_CASLE);

        File targetFile = new File("/home/tomchuck/tmp/race-results.xlsx");


        ChampionshipExportService.exportAsExcel(raceResults, targetFile);

    }

    @Test
    public void should_export_race_results_as_pdf(){
        Championship championship = new Championship();
        Collection<Driver> drivers = new TextDriverRepository().loadDrivers();

        Collection<Driver> qualified = championship.qualifications(drivers, Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championship.race(qualified, Circuit.BOWSER_CASLE);

        File targetFile = new File("/home/tomchuck/tmp/race-results.pdf");


        ChampionshipExportService.exportAsPdf(raceResults, targetFile);

    }

    @Test
    public void should_perform_championship(){
        Championship championship = new Championship();
        Collection<Driver> drivers = new TextDriverRepository().loadDrivers();

        Map<Circuit, Collection<Performance>> championshipResults = championship.perform(drivers);

        Assertions.assertThat(championshipResults)
                .isNotEmpty()
                .hasSize(4);

        log.debug("test passed");
    }

    @Test
    public void should_compute_race_points(){
        Championship championship = new Championship();
        Collection<Driver> drivers = new TextDriverRepository().loadDrivers();
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
        Collection<Driver> drivers = new TextDriverRepository().loadDrivers();
        Map<Circuit, Collection<Performance>> championshipResults = championship.perform(drivers);

        Collection<PointsPerDriver> pointsPerDriver = championship.computeChampionshipPoints(championshipResults);


        pointsPerDriver.stream().forEach(ppdriver -> System.out.println("Driver : "+ppdriver.getDriver().getName()+" points "+ppdriver.getPoints()));
    }

}