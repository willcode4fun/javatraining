package com.valtech.talent.program.patterns.model;

import com.valtech.talent.program.patterns.PojoSample;

public class ImmutableDinosaur {

    private final String name;
    private final PojoSample.Diet diet;

    public ImmutableDinosaur(String name, PojoSample.Diet diet) {
        this.name = name;
        this.diet = diet;
    }

    public String getName() {
        return name;
    }

    public PojoSample.Diet getDiet() {
        return diet;
    }

}
