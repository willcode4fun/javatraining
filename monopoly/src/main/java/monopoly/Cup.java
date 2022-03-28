package monopoly;

public class Cup {
    // Implement a cup here

    private int faceValue;

    private final Die die1;

    private final Die die2 ;

    public Cup(Die die1, Die die2) {
        this.die1 = die1;
        this.die2 = die2;
    }

    public void roll() {
        die1.roll();
        die2.roll();
        faceValue = die1.getValue()+ die2.getValue();
    }

    public int getValue() {
        return faceValue;
    }
}
