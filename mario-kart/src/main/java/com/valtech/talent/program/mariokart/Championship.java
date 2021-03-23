package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Driver;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.DriverCategory;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class Championship {

    public Collection<Driver> loadDrivers() {
        List<String> list = null;
        try {
            list = IOUtils.readLines(this.getClass().getResourceAsStream("/drivers.txt"), StandardCharsets.UTF_8);
            System.out.println(list);
            list.stream()
                    .filter(s -> !s.isBlank())
                    .filter(s -> Pattern.matches("[a-zA-Z; \\.]*", s))
                    .filter(s -> s.contains(";"))
                    .map(s -> s.split(";"))
                    .map(arr -> new Driver(arr[0], DriverCategory.valueOf(arr[1])))
            .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;

    }
}
