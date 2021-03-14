package com.valtech.talent.program.functional;

import com.valtech.talent.program.patterns.model.Dinosaur;

import java.util.Optional;

public class OptionalSample {

    public static void main(String[] args) {

        Dinosaur dinosaur = new Dinosaur();
        String val = null;

        // Optional creation

        Optional<String> optional1 = Optional.empty();

        Optional<String> optional2 = Optional.of("TEST");

        Optional<String> optional3 = Optional.ofNullable(val);

        // Optional usage

        boolean present = optional1.isPresent();

        boolean empty = optional2.isEmpty();

        // Conditional action

        optional1.ifPresent(System.out::println);

        optional1.ifPresentOrElse(System.out::println, () -> System.out.println("empty"));

        optional1.orElseThrow(() -> new RuntimeException());

        // Retrieve value

        String s = optional1.get();

        String toto = optional1.orElse("TOTO");

        String s1 = optional1.orElseGet(dinosaur::getName);

        // Transformations

        Optional<String> optional4 = optional1.filter(String::isBlank);
        Optional<Integer> optionalInteger = optional1.map(Integer::valueOf);

        Optional<Dinosaur> optionalDinosaur = Optional.ofNullable(dinosaur);
        Optional<Optional<String>> optionalName = optionalDinosaur.map(d -> Optional.ofNullable(d.getName()));
        Optional<String> optionalName2 = optionalDinosaur.flatMap(d -> Optional.ofNullable(d.getName()));


    }
}
