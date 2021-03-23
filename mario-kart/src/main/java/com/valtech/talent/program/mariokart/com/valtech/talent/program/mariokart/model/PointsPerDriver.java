package com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model;

public class PointsPerDriver {
    private final Driver driver;
    private final int points;

    public PointsPerDriver(Driver d, int points) {
        this.driver = d;
        this.points = points;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getPoints() {
        return points;
    }
}
