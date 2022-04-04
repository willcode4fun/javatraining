package com.valtech.talent.program.mariokart.driver;

import com.valtech.talent.program.mariokart.model.Driver;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.eval.NotImplementedException;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.valtech.talent.program.mariokart.model.DriverCategory.M;
import static com.valtech.talent.program.mariokart.model.DriverCategory.valueOf;

public class TextDriverRepository implements DriverRepository {

    public static final String DRIVERS_TXT = "/data/drivers.txt";

    public Collection<Driver> loadDrivers() {
        // TODO : Task 1.2
        return Collections.emptyList();
    }

    private List<String> getFileContent() {
        // TODO : Task 1.1
        try {
            return IOUtils.readLines(this.getClass().getResourceAsStream(DRIVERS_TXT), StandardCharsets.UTF_8);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Driver mapDriver(String[] arr){
        // TODO : Task 1.3
        return null;
    }


}
