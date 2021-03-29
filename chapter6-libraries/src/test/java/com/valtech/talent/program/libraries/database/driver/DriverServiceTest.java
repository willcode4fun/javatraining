package com.valtech.talent.program.libraries.database.driver;


import com.valtech.talent.program.libraries.SpringSample;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringSample.class)
public class DriverServiceTest {

    @Autowired
    private DriverService driverService;

    @Before
    public void init(){
        driverService.saveDriver(new Driver(1l,"toto","A"));
    }

    @Test
    public void should_find_driver(){
        Driver toto = driverService.findByName("toto");

        Assertions.assertThat(toto).isNotNull();
        Assertions.assertThat(toto.getType()).isEqualTo("A");
    }

}