package com.valtech.talent.program.patterns.model;

import com.valtech.talent.program.patterns.BuilderSample;

public class Car {
    private String color;
    private int wheels;
    private String model;
    private String licensePlate;

    public Car(String color, int wheels, String model, String licensePlate) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public int getWheels() {
        return wheels;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }


    public static CarBuilder builder(){
        return new CarBuilder();
    }

    public static class CarBuilder{
        private String color = "blue";
        private int wheels = 4;
        private String model;
        private String licensePlate;

        public CarBuilder withColor(String color){
            this.color = color;
            return this;
        }

        public CarBuilder withWheels(int wheels){
            this.wheels = wheels;
            return this;
        }

        public CarBuilder withModel(String model){
            this.model = model;
            return this;
        }

        public CarBuilder withLicensePlate(String licensePlate){
            this.licensePlate = licensePlate;
            return this;
        }

        public Car build(){
            return new Car(color,wheels,model,licensePlate);
        }
    }
}
