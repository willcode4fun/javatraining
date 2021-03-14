package monopoly.ranking;

public class GlobalRankingService {

    private EpicRankingService epicRankingService;
    private SteamRankingService steamRankingService;

    public GlobalRankingService(EpicRankingService epicRankingService, SteamRankingService steamRankingService){
        this.epicRankingService = epicRankingService;
        this.steamRankingService = steamRankingService;
    }


    public PlayerRankings getRankings() {
        epicRankingService.getRankings();
        return null;
    }
}
