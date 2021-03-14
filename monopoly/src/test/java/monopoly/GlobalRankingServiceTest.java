package monopoly;

import monopoly.ranking.EpicRankingService;
import monopoly.ranking.GlobalRankingService;
import monopoly.ranking.PlayerRankings;
import monopoly.ranking.SteamRankingService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GlobalRankingServiceTest {


    @Mock
    private EpicRankingService epicRankingService;

    @Spy
    private  SteamRankingService steamRankingService;

    @Before
    private void init(){

    }


    @Test
    public void should_get__global_rankings(){
        GlobalRankingService service = new GlobalRankingService(epicRankingService, new SteamRankingService());
        when(epicRankingService.getRankings(anyInt())).thenReturn(new PlayerRankings());


        PlayerRankings playerRankings = service.getRankings();

        Assertions.assertThat(playerRankings).isNotNull();

        Mockito.verify(steamRankingService.getRankings(anyInt()), times(2));


    }
}
