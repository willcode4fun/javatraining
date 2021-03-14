package com.valtech.talent.program;

public class ControlStructuresSample {

    private enum Sample {A, B, C, D}

    public static void main(String[] args) {

        boolean condition = true, condition2 = true, condition3 = true;

        while ( condition  ) {
            // ... do something
        }

        for (int i = 0 ; i < 10; i++ ) {
            // ... do something
        }

        for (Sample sample :Sample.values()){
            // ... do something
        }

        if (condition2) {
            // ... do something
        } else if (condition3) {
            // ... do something
        } else {
            // ... do something
        }

        Sample expression = condition ? Sample.B : Sample.C;

        switch (expression) {
            case A :
                // ... do something for A
                break;

            case B :
            case C :
                // ... do something for B or C
                break;
            default :
                // ... do something for anything else
        }

    }
}