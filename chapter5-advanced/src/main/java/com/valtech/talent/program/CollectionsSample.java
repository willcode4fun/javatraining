package com.valtech.talent.program;

import java.util.*;
import java.util.stream.Stream;

public class CollectionsSample {

    public static void main(String[] args) {
        aboutArrays();

        aboutCollections();

        aboutSets();

        aboutMaps();

    }
    private static void aboutArrays() {
        String[] anArray = new String[] {"Triceratops", "Tyrannosaurus", "Iguanodon"};

        for (int i = 0; i < anArray.length; i++) {
            System.out.println(anArray[i]);
        }

        for( String element : anArray) {
            System.out.println("Element : " + element);
        }

        Stream.of(anArray)
            .forEach(System.out::println);
    }

    private static void aboutCollections() {
        Collection<String> aCollection = new ArrayList<>();
        aCollection.add("Triceratops");
        aCollection.add("Tyrannosaurus");
        aCollection.add("Iguanodon");

        for( String element : aCollection) {
            System.out.println("Element : " + element);
        }

        Collection<String> anotherCollection = List.of("Triceratops", "Tyrannosaurus", "Iguanodon");

        anotherCollection.iterator().forEachRemaining(System.out::println);
    }

    private static void aboutSets() {
        Set<String> aSet = new HashSet<>();
        aSet.add("Triceratops");
        aSet.add("Tyrannosaurus");
        aSet.add("Iguanodon");

        Set<String> anotherSet = Set.of("Triceratops", "Tyrannosaurus", "Iguanodon");


        for( String element : aSet) {
            System.out.println("Element : " + element);
        }
    }

    private static void aboutMaps() {
        // old school Map

        Map<String, String> aMap = new HashMap<>();
        aMap.put("5", "Triceratops");
        aMap.put("7", "Tyrannosaurus");
        aMap.put("11", "Iguanodon");

        for(Map.Entry<String, String> entry : aMap.entrySet()) {
            System.out.println("key : " + entry.getKey() + "value : "+entry.getValue());
        }

        for(String key : aMap.keySet()) {
            String value = aMap.get(key);
            System.out.println("key : " +key + "value : "+value);
        }

        // Map Since JAVA 9 / 11 :

        Map<String, String> anotherMap = Map.of(
                "A", "Triceratops",
                "B", "Tyrannosaurus",
                "C", "Iguanodon");

        anotherMap.forEach((k,v) -> System.out.println("key : " + k + "value : "+v));
    }

}
