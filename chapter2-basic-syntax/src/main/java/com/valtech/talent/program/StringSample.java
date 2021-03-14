package com.valtech.talent.program;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringSample {

    private static final String CONSTANT_STRING = "A simple String sample : %s - %f";

    private static String buildString(String src) {
        StringBuilder sb = new StringBuilder(src).append("and ").append("more ").append("numbers ");
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] stringExamples = {

                CONSTANT_STRING,
                // A simple String sample : %s - %f
                CONSTANT_STRING.replace('e', '\u01B1'),
                // A simplƱ String samplƱ : %s - %f
                String.format(CONSTANT_STRING, "toto", 28.32f),
                // A simple String sample : toto - 28,320000
                CONSTANT_STRING.toUpperCase(),
                //  SIMPLE STRING SAMPLE : %S - %F
                buildString(CONSTANT_STRING),
                // A simple String sample : %s - %fand more numbers 0123456789
                Pattern.compile("[aeiou]").matcher(CONSTANT_STRING).replaceAll("*"),
                // A s*mpl* Str*ng s*mpl* : %s - %f
                CONSTANT_STRING.replaceAll("[aeiou]", "#")
                // A s#mpl# Str#ng s#mpl# : %s - %f
        };

        Stream.of(stringExamples)
                .forEach(System.out::println);
    }
}
