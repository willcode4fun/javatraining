package com.valtech.talent.program.libraries;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.math.IntMath;

import java.util.Map;

public class GuavaSample {

    public static void main(String[] args) {

        Map items = ImmutableMap.of("coin", 3, "glass", 4, "pencil", 1);

        ImmutableList<String> immutableList = ImmutableList.of("a", "b", "c");

        boolean result = IntMath.isPrime(20);


    }
}
