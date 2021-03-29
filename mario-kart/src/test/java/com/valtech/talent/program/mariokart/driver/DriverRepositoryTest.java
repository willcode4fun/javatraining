package com.valtech.talent.program.mariokart.driver;

import com.valtech.talent.program.mariokart.MarioKartApplication;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Driver;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.DriverCategory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarioKartApplication.class)
public class DriverRepositoryTest {

    @Autowired
    public DriverRepository driverRepository;


    @Test
    public void should_save_driver() {
        Driver driver = new Driver("toto", DriverCategory.M);

        Driver saved = driverRepository.save(driver);

        Assertions.assertThat(saved).isNotNull();
    }

}