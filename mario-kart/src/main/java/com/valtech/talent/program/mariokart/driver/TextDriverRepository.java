package com.valtech.talent.program.mariokart.driver;

import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Driver;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.DriverCategory.M;
import static com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.DriverCategory.valueOf;

public class TextDriverRepository implements DriverRepository {

    public static final String DRIVERS_TXT = "/drivers.txt";

    public Collection<Driver> loadDrivers() {
        return getFileContent()
                .stream()
                .filter(DriverUtils::validateLine)
                .map(s -> s.split(";"))
                .map(this::mapDriver)
                //.peek(System.out::println)
                .collect(Collectors.toList());
    }

    private List<String> getFileContent() {
        try {
            return IOUtils.readLines(this.getClass().getResourceAsStream(DRIVERS_TXT), StandardCharsets.UTF_8);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Driver mapDriver(String[] arr){
        return new Driver(arr[0], arr.length > 1? valueOf(arr[1]): M);
    }


}
