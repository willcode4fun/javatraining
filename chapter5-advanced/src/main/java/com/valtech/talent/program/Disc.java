package com.valtech.talent.program;

public class Disc implements Shape {

    private final double r;

    public Disc(double r) {
        this.r = r;
    }

    @Override
    public double computeSurface() {
        return r*r*Math.PI;
    }
}
