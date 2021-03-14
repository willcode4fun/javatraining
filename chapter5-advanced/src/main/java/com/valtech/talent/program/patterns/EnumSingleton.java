package com.valtech.talent.program.patterns;

public enum EnumSingleton {
    INSTANCE;
    void sayHi(){
        System.out.println("Hi World!");
    }

    public static void main(String[] args) {

        EnumSingleton.INSTANCE.sayHi();

    }
}
