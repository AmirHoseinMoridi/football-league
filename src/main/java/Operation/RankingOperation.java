package Operation;

import Repository.Ranking.Impl.RankingRepositoryImpl;
import Service.Ranking.Impl.RankingServiceImpl;
import Service.Ranking.RankingService;
import Util.config.JpaUtil;

import java.time.Year;

public class RankingOperation {
    private final RankingService rankingService = new RankingServiceImpl(new RankingRepositoryImpl(JpaUtil.getEntityManager()));


    public void showScoresOfEachTeam(Year year){
        System.out.println(rankingService.findByYear(year));
    }

    public void showChampionOfYear(Year year){
        System.out.println(rankingService.ChampionOfYear(year).getTeam());
    }

}
