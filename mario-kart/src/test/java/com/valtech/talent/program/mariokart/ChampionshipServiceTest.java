package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.driver.JpaDriverRepository;
import com.valtech.talent.program.mariokart.model.Circuit;
import com.valtech.talent.program.mariokart.model.Driver;
import com.valtech.talent.program.mariokart.model.Performance;
import com.valtech.talent.program.mariokart.model.PointsPerDriver;
import com.valtech.talent.program.mariokart.driver.ExcelDriverRepository;
import com.valtech.talent.program.mariokart.driver.TextDriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@Slf4j
public class ChampionshipServiceTest extends BaseStpringTest {
    
    @Autowired
    private ChampionshipService championshipService;


    @Autowired
    protected JpaDriverRepository driverRepository;

    @Before
    public void init(){
        new TextDriverRepository().loadDrivers()
                .stream()
                .forEach(driverRepository::save);
    }

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

        Collection<Driver> qualified = championshipService.qualifications(Circuit.BOWSER_CASLE);

        Assertions.assertThat(qualified)
                .isNotEmpty()
                .hasSize(10);
    }

    @Test
    public void should_perform_race(){

        Collection<Driver> qualified = championshipService.qualifications( Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championshipService.race(qualified, Circuit.BOWSER_CASLE);

        Assertions.assertThat(raceResults)
                .isNotEmpty()
                .hasSize(10);
    }

    @Test
    public void should_export_race_results() throws IOException {

        Collection<Driver> qualified = championshipService.qualifications( Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championshipService.race(qualified, Circuit.BOWSER_CASLE);

        File targetFile = File.createTempFile("race-results","xlsx");


        ChampionshipExportService.exportAsExcel(raceResults, targetFile);

    }

    @Test
    public void should_export_race_results_as_pdf() throws IOException {

        Collection<Driver> qualified = championshipService.qualifications( Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championshipService.race(qualified, Circuit.BOWSER_CASLE);

        File targetFile = File.createTempFile("race-results","pdf");


        ChampionshipExportService.exportAsPdf(raceResults, targetFile);

    }

    @Test
    public void should_perform_championship(){

        Map<Circuit, Collection<Performance>> championshipResults = championshipService.perform();

        Assertions.assertThat(championshipResults)
                .isNotEmpty()
                .hasSize(4);

        log.debug("test passed");
    }

    @Test
    public void should_compute_race_points(){

        Collection<Driver> qualified = championshipService.qualifications(Circuit.BOWSER_CASLE);
        Collection<Performance> raceResults = championshipService.race(qualified, Circuit.BOWSER_CASLE);

        Collection<PointsPerDriver> pointsPerDriver = championshipService.computeRacePoints(raceResults);

        Assertions.assertThat(pointsPerDriver)
                .isNotEmpty()
                .hasSize(10);

    }


    @Test
    public void should_compute_championship_points(){
        Map<Circuit, Collection<Performance>> championshipResults = championshipService.perform();

        Collection<PointsPerDriver> pointsPerDriver = championshipService.computeChampionshipPoints(championshipResults);


        pointsPerDriver.stream().forEach(ppdriver -> System.out.println("Driver : "+ppdriver.getDriver().getName()+" points "+ppdriver.getPoints()));
    }

}