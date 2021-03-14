package com.valtech.talent.program.functional;

import com.valtech.talent.program.patterns.model.Dinosaur;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceSample {

    public static void main(String[] args) {

        Dinosaur dino = new Dinosaur();

        Consumer<String[]> consumer2 = MethodReferenceSample::main;
        Consumer<Object> consumer = System.out::println;

        Function<Dinosaur,String> func = Dinosaur::getName;

        Supplier<String> supplier = dino::getName;

        Supplier<Dinosaur> supplier2 = Dinosaur::new;

    }
}
