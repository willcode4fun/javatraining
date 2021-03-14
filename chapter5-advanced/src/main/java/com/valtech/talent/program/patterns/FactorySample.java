package com.valtech.talent.program.patterns;

public class FactorySample {

    public abstract class Transport {
        abstract void move();
    }

    public class Car extends Transport {
        @Override
        void move() {
            System.out.println("drive");
        }
    }

    public class Plane extends Transport {
        @Override
        void move() {
            System.out.println("fly");
        }
    }

    public class Bike extends Transport {
        @Override
        void move() {
            System.out.println("ride");
        }
    }

    public class TransportFacctory {

        public Transport getTransport(int travelDistance){
            if(travelDistance < 10){
                return new Bike();
            } else if(travelDistance < 500) {
                return new Car();
            } else {
                return new Plane();
            }
        }
    }


    public static void main(String[] args) {
        //TransportFacctory
    }
}
