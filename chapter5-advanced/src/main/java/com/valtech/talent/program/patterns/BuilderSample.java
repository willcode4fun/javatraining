package com.valtech.talent.program.patterns;

import com.valtech.talent.program.patterns.model.Car;

public class BuilderSample {


    public void run(){

        Car.builder()
            .withColor("green")
            .withWheels(4)
            .build();
    }


    public static void main(String[] args) {
        new BuilderSample().run();
    }
}
