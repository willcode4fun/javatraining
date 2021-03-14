package com.valtech.talent.program.patterns;

import com.valtech.talent.program.patterns.model.Dinosaur;

public class PojoSample {


    public enum Diet {HERBIVORE, CARNIVORE}


    public static void main(String[] args) {

        Dinosaur dinosaur = new Dinosaur();
        dinosaur.setName("Triceratops");
        dinosaur.setDiet(Diet.HERBIVORE);
        System.out.println(dinosaur.getName() + " " + dinosaur.getDiet());

    }
}
