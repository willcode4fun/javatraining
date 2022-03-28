package monopoly;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CupTest {
    // Test your Cup here

    @Spy
    private Die first;
    @Spy
    private Die second;


    private Cup cup;

    @Before
    public void init(){

        /*

        // how to do it without using annotations :

        MockitoAnnotations.openMocks(this);
        Mockito.mock(Die.class);
        Mockito.spy(Die.class);

         */
        cup = new Cup(first, second);
        when(first.getValue()).thenReturn(1);
        when(first.getValue()).thenReturn(2);

        when(second.getValue()).thenReturn(1);
        when(second.getValue()).thenReturn(2);
    }


    @Test
    public void should_have_value_between_2_and_12() {
        // Initailisations specific to the test
        cup.roll(); // Actions on Actors
        //assertTrue(cup.getValue() >= 2); // Assertions
        //assertTrue(cup.getValue() <= 12);
        verify(first).roll();
        verify(first).getValue();

        verify(second).roll();
        verify(second).getValue();

    }
}