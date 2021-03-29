package com.valtech.talent.program.mariokart.driver;

import java.util.regex.Pattern;

public class DriverUtils {
    public static boolean validateLine(String line){
        return !line.isBlank() && Pattern.matches("[a-zA-Z; \\.]*", line);

    }
}
