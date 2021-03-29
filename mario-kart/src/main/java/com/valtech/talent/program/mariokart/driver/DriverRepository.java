package com.valtech.talent.program.mariokart.driver;

import com.valtech.talent.program.mariokart.model.Driver;

import java.util.Collection;

public interface DriverRepository {

    Collection<Driver> loadDrivers();
}
