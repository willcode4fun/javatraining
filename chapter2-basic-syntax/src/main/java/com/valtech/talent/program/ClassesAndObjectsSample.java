package com.valtech.talent.program;

import java.util.List;

import static java.util.List.of;

public class ClassesAndObjectsSample {

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

    public interface EnergySource {
        void refill();
    }

    public interface GasPowered extends EnergySource{
        default void refillTank() {
            System.out.println("Fill gas tank");
        }
    }

    public interface ElectricPowered extends EnergySource{
        default void refillBattery() {
            System.out.println("Fill batteries");
        }
    }

    public class GasPoweredCar extends Car implements GasPowered {
        public void refill(){
            this.refillTank();
        }
    }

    public class ElectricCar extends Car implements ElectricPowered {
        public void refill(){
            this.refillBattery();
        }
    }

    public class ElectricBike extends Bike implements ElectricPowered {
        public void refill(){
            this.refillBattery();
        }
    }

    public class HybridCar extends Car implements ElectricPowered, GasPowered {
        public void refill(){
            this.refillBattery();
            this.refillTank();
        }
    }

    public void transport(){

        List<Transport> vehicles = of(
            new Bike(),
            new GasPoweredCar(),
            new ElectricBike(),
            new HybridCar(),
            new ElectricCar());

        for (int i = 0; i < vehicles.size(); i++) {
            Transport vehicle =  vehicles.get(i);
            vehicle.move();
            if(vehicle instanceof EnergySource){
                ((EnergySource) vehicle).refill();
            }
        }

/*
        vehicles.stream()
                .peek(Transport::move)
                .filter(EnergySource.class::isInstance)
                .map(EnergySource.class::cast)
                .forEach(EnergySource::refill);
*/
    }


    public static void main(String[] args) {
        new ClassesAndObjectsSample().transport();
    }

}
