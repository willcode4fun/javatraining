package com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model;

public class Driver {
    private String name;
    private DriverCategory category;

    public Driver(String name, DriverCategory category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
