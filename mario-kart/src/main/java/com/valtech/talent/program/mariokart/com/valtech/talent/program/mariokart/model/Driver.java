package com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model;

public class Driver {
    private final String name;
    private final DriverCategory category;

    public Driver(String name, DriverCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public DriverCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", category=" + category +
                '}';
    }

}
