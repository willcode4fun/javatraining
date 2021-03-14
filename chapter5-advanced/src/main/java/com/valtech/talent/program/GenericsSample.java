package com.valtech.talent.program;

import com.valtech.talent.program.patterns.model.Dinosaur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsSample {

    public static  <T extends Shape> double computeSurface(List<T> shapes) {

        double surface = 0.0;
        for(T shape : shapes){
            surface += shape.computeSurface();
        }
        return surface;
    }







    public List convertToList(String[] list) {

        List result = new ArrayList<>();
        for(String el : list) {
            result.add(el);
        }
        return result;

    }





    public <T extends Dinosaur> List<T> convertToList(T[] list) {

        List<T> result = new ArrayList<>();

        for(T el : list) {
            el.getName();
            result.add(el);
        }

        return result;
    }


    public <K, V> Map<K,V>  convertToList(K[] keys, V[] values) {

        Map<K,V> map= new HashMap<>();

        return map;
    }




    public static class Box<T> {

        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }












    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("Hello World");

        System.out.printf("Integer Value :%d\n\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
    }

}
