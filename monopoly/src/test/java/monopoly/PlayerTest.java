package monopoly;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class PlayerTest {

    private Player player;


    private Square square;
    private Square anotherSquare;

    @Before
    public void init(){

        square = spy(new Square("toto"));
        anotherSquare = spy(new Square("bob"));
        when(square.getNextSquare()).thenReturn(anotherSquare);
        when(anotherSquare.getNextSquare()).thenReturn(square);

        player = new Player("test", square);
    }


    @Test
    public void should_take_turn(){
        System.out.println("Square : "+player.getLocation());

        player.takeTurn();

        verify(anotherSquare).passOverBy(any());

    }

}