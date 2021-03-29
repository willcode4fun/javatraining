package com.valtech.talent.program.mariokart.driver;

import com.valtech.talent.program.mariokart.BaseStpringTest;
import com.valtech.talent.program.mariokart.MarioKartApplication;
import com.valtech.talent.program.mariokart.model.Driver;
import com.valtech.talent.program.mariokart.model.DriverCategory;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarioKartApplication.class)
public class DriverRepositoryTest extends BaseStpringTest {


    @Autowired
    protected JpaDriverRepository driverRepository;

    @Before
    public void init(){
        new TextDriverRepository().loadDrivers()
                .stream()
                .forEach(driverRepository::save);
    }

    @Test
    public void should_save_driver() {
        Driver driver = new Driver(10000l, "toto", DriverCategory.M);

        Driver saved = driverRepository.save(driver);

        Assertions.assertThat(saved).isNotNull();
    }

    @Test
    public void should_load_all_drivers() {

        List<Driver> driverList = driverRepository.findAll();

        Assertions.assertThat(driverList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(41);
    }

}