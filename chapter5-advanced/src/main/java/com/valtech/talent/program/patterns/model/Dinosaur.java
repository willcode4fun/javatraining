package com.valtech.talent.program.patterns.model;

import com.valtech.talent.program.patterns.PojoSample;

public class Dinosaur {

    private String name;
    private PojoSample.Diet diet;

    public Dinosaur() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PojoSample.Diet getDiet() {
        return diet;
    }

    public void setDiet(PojoSample.Diet diet) {
        this.diet = diet;
    }
}
