package com.valtech.talent.program.functional;

import java.util.function.*;

public class LambdaSample {

    public static void main(String[] args) {

        // Runnable no input parameters no return value

        Runnable process = () -> System.out.println("Hello World");

        // Consumer input parameters but no return value

        Consumer<String> afficher = a -> System.out.println("A=" + a);

        BiConsumer<String, String> afficher2 = (a,b) -> System.out.println("A=" + a + ", B="+b);

        // Function input parameters and return value

        Function<String, String> func = a -> a + " TEST";

        BiFunction<String, String, String> func2 = (a,b) ->  a + " TEST " + b;

        // Supplier no input returns a value

        Supplier<String> supplier = () -> "TOTO";



    }
}
