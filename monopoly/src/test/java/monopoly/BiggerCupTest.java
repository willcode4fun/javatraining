package monopoly;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BiggerCupTest {

    private List<Die> dice;

    private BiggerCup cup;

    @Before
    public void init(){

        // PREPARE

        dice = IntStream.of(1,2,3,4).mapToObj(
                integer -> {
                    Die die = Mockito.mock(Die.class);
                    when(die.getValue()).thenReturn(1);
                    when(die.getValue()).thenReturn(2);
                    return die;
                }
        ).collect(Collectors.toList());

        cup = new BiggerCup(dice);

    }

    @Test(expected = IllegalArgumentException.class)
    public void die_number_must_be_at_least_2(){

        new BiggerCup(Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void die_number_must_be_under_6(){
        List<Die> diceList = IntStream.range(1,7)
                .mapToObj(i -> new Die())
                .collect(Collectors.toList());

        new BiggerCup(diceList);
    }


    @Test
    public void should_throw_dice() {

        // PERFORM
        cup.roll();

        // CHECK
        dice.forEach(die -> {
            verify(die).roll();
            verify(die).getValue();
        });
    }

}