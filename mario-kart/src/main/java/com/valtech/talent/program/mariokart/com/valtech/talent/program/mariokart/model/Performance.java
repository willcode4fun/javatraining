package com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model;

public class Performance {
    private final Driver driver;
    private final double timeInSeconds;

    public Performance(Driver d, double timeInSeconds) {
        this.driver = d;
        this.timeInSeconds = timeInSeconds;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getTimeInSeconds() {
        return timeInSeconds;
    }
}
