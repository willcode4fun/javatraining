package monopoly;

import monopoly.ranking.*;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GlobalRankingServiceTest {


    @Mock
    private EpicRankingService epicRankingService;

    @Mock
    private VeryComplicatedStuff complicatedStuff;

    private  SteamRankingService steamRankingService;

    @Before
    public void init(){
        when(epicRankingService.getRankings(anyInt())).thenReturn(new PlayerRankings());

        steamRankingService = Mockito.spy(new SteamRankingService(complicatedStuff));
        doReturn(new PlayerRankings()).when(steamRankingService).getRankings(anyInt());
    }


    @Test
    public void should_get_global_rankings(){
        // PREPARE
        GlobalRankingService service = new GlobalRankingService(epicRankingService, steamRankingService);

        // PERFORM
        PlayerRankings playerRankings = service.getRankings();

        // CHECK
        Assertions.assertThat(playerRankings).isNotNull();

        Mockito.verify(steamRankingService).getRankings(anyInt());

    }
}
