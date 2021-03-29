package com.valtech.talent.program.mariokart.driver;

import com.valtech.talent.program.mariokart.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface JpaDriverRepository extends JpaRepository<Driver,Long> {

    @Query("select d from com.valtech.talent.program.mariokart.model.Driver d")
    Collection<Driver> loadDrivers();
}
