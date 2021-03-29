package com.valtech.talent.program.libraries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerSample {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggerSample.class);

    public static void main(String[] args) {


        LOGGER.trace("trace {} {}", 12, "ABC");

        LOGGER.debug("debug information used for dev {} {}", 12, "ABC");

        LOGGER.info("information that may be used in production logs ");

        LOGGER.warn("warn :");

        LOGGER.error("error :", new RuntimeException("there is an exception"));
    }

}
