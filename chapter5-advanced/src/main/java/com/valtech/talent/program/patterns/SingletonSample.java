package com.valtech.talent.program.patterns;

public class SingletonSample {

    // VANILLA JAVA : this example is only for explanation purpose

    private SingletonSample(){}

    private final static SingletonSample INSTANCE = new SingletonSample();

    public static SingletonSample getInstance(){
        return INSTANCE;
    }




    public void sayHello(){
        System.out.println("Hello World!");
    }









    // With an enum : a safer way to code a vanilla java Singleton
    // prefered

    private enum EnumSingleton {

        INSTANCE;

        void sayHi(){
            System.out.println("Hi World!");
        }
    }


    public static void main(String[] args) {



        SingletonSample.getInstance().sayHello();





        EnumSingleton.INSTANCE.sayHi();



    }
}
