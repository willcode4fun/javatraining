package com.valtech.talent.program.patterns;

import com.valtech.talent.program.patterns.model.ImmutableDinosaur;

import static com.valtech.talent.program.patterns.PojoSample.Diet.HERBIVORE;

public class ImmutableSample {

    public static void main(String[] args) {
        ImmutableDinosaur dinosaur = new ImmutableDinosaur("Triceratops",HERBIVORE);

        System.out.println(dinosaur.getName() + " " + dinosaur.getDiet());
    }
}
