package com.valtech.talent.program.mariokart.model;

import java.util.Random;

public enum Circuit {

    MARIO_CIRCUIT(122,1.0, 1.1, 1.2),
    BOWSER_CASLE(183,1.2, 1.1, 0.9),
    DK_JUNGLE(150,1.1, 1.1, 1.0),
    RAINBOW_ROAD(212,1.2, 1.0, 1.1);

    private int durationInSeconds;
    private double sFactor;
    private double mFactor;
    private double lFactor;

    private static Random rnd = new Random(System.currentTimeMillis());

    Circuit(int durationInSeconds, double sFactor, double mFactor, double lFactor) {
        this.durationInSeconds = durationInSeconds;
        this.sFactor = sFactor;
        this.mFactor = mFactor;
        this.lFactor = lFactor;
    }

    public double perform(DriverCategory category) {
        double initalDuration = this.durationInSeconds * (0.9 + (rnd.nextFloat() * 0.2));
        switch (category){
            case L: return initalDuration * lFactor;
            case M: return initalDuration * mFactor;
            case S: return  initalDuration * sFactor;
            default: return 0;
        }
    }

}
