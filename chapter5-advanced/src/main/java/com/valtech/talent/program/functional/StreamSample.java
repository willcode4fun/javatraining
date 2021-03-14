package com.valtech.talent.program.functional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample {

    public static void main(String[] args) {


        // Stream creation

        Stream<String> emptyStream = Stream.empty();

        Stream<String> stream = Stream.of("AA", "BB", "CC");

        String[] array = new String[] {"AA", "BB", "CC"};

        Stream<String> stringStream = Stream.of(array);

        Collection<String> collection = Arrays.asList("AA", "BB", "CC");

        Stream<String> stringStream1 = collection.stream();

        Stream<String> stringStream2 = Stream.<String>builder().add("AA").add("BB").add("CC").build();

        Stream<String> streamGenerated = Stream.generate(() -> "TOTO").limit(10);

        Stream<String> streamSplitted ="AA\nBB\nCC".lines();



        // Stream transformation

        Stream<String> skiped = stream.skip(2);

        Stream<String> limited = stringStream.limit(2);

        Stream<String> sorted = stringStream1
                .peek(System.out::println)
                .filter(s -> s.length() < 100)
                .map(String::toUpperCase)
                .distinct()
                .sorted();

        stringStream2.flatMap(s -> Stream.of(s.split(",")));

        // Terminal Operations

        Optional<String> first = streamGenerated.findFirst();
        Optional<String> any = streamGenerated.findAny();

        boolean noneMatch = streamGenerated.noneMatch(String::isBlank);
        boolean anyMatch = streamGenerated.anyMatch(String::isBlank);
        boolean allMatch = streamGenerated.allMatch(String::isBlank);

        long count = streamGenerated.count();

        streamGenerated.forEach(System.out::println);

        List<String> collect = streamGenerated.collect(Collectors.toList());
        String collect1 = streamGenerated.collect(Collectors.joining(","));
        Optional<String> reduce = streamGenerated.reduce((a, b) -> a + " " + b);

    }
}
