package com.valtech.talent.program.libraries.database.driver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverService {

    private final DriverRepository driverRepository;

    public Driver findByName(String name){
        return driverRepository.findByName(name);
    }

    public void saveDriver(Driver driver){
        driverRepository.save(driver);
    }

}
