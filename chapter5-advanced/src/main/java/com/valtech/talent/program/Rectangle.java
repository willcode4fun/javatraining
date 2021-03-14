package com.valtech.talent.program;

public class Rectangle implements Shape{

    double l,h;

    public Rectangle(double l, double h) {
        this.l = l;
        this.h = h;

    }

    @Override
    public double computeSurface() {
        return l*h;
    }
}
