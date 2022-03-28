package monopoly;

import java.util.List;

public class BiggerCup {

    private int value;

    private final List<Die> dice;


    public BiggerCup(List<Die> dice) {
        if(dice.size() <2 || dice.size() > 6){
            throw new IllegalArgumentException("Dice number must be between 2 and 6");
        }
        this.dice = dice;
    }

    public void roll() {

        dice.forEach(Die::roll);

        value = dice.stream()
                .mapToInt(Die::getValue)
                .sum();
    }

    public int getValue() {
        return value;
    }
}
