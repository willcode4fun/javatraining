package monopoly;

import monopoly.MonopolyGame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MonopolyGameTest {

    @Test
    public void should_add_new_player(){
        MonopolyGame monopolyGame = new MonopolyGame(5,5);


        monopolyGame.addPlayer();


        assertThat(monopolyGame.getPlayerCount()).isEqualTo(6);
    }

    @Test
    public void should_remove_player(){
        MonopolyGame monopolyGame = new MonopolyGame(5,5);


        monopolyGame.removePlayer();

    }

    @Test(expected = RuntimeException.class)
    public void should_not_remove_player_if_player_count_under_3(){
        MonopolyGame monopolyGame = new MonopolyGame(2,5);


        monopolyGame.removePlayer();


        //assertThat(monopolyGame.getPlayerCount()).isEqualTo(2);
    }


}
