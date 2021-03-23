package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Driver;
import org.junit.Test;

import java.util.Collection;
import org.assertj.core.api.Assertions;

public class ChampionshipTest {

    @Test
    public void should_load_drivers(){
        Championship championship = new Championship();

        Collection<Driver> drivers = championship.loadDrivers();

        Assertions.assertThat(drivers).isNotEmpty().hasSize(41);
    }

}