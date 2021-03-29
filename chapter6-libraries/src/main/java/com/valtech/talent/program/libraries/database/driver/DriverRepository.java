package com.valtech.talent.program.libraries.database.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    Driver findByName(String name);

    @Query("SELECT d FROM Driver d WHERE d.type = 'S'")
    Collection<Driver> findSmallDrivers();

}
