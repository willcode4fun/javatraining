package com.valtech.talent.program.mariokart.model;

import java.util.Collection;

public class CircuitQualif {
    private Circuit circuit;
    private Collection<Driver> qualified;

    public CircuitQualif(Circuit circuit, Collection<Driver> qualified) {
        this.circuit = circuit;
        this.qualified = qualified;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public Collection<Driver> getQualified() {
        return qualified;
    }
}
