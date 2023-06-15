package Operation;

import Entity.*;
import Repository.Goal.Impl.GoalRepositoryImpl;
import Repository.Match.Impl.MatchRepositoryImpl;
import Repository.Ranking.Impl.RankingRepositoryImpl;
import Service.Goal.GoalService;
import Service.Goal.Impl.GoalServiceImpl;
import Service.Match.Impl.MatchServiceImpl;
import Service.Match.MatchService;
import Service.Ranking.Impl.RankingServiceImpl;
import Service.Ranking.RankingService;
import Util.config.JpaUtil;

import java.time.Year;
import java.util.Optional;

public class MatchOperation {

    private final MatchService matchService = new MatchServiceImpl(new MatchRepositoryImpl(JpaUtil.getEntityManager()));

    private final GoalService goalService = new GoalServiceImpl(new GoalRepositoryImpl(JpaUtil.getEntityManager()));

    private static final RankingService RANKING_SERVICE = new RankingServiceImpl(new RankingRepositoryImpl(JpaUtil.getEntityManager()));

    public void startMatch(Team guest, Team host) {
        Match match = new Match();
        match.setGuest(guest);
        match.setHost(host);
        matchService.save(match);
    }


    public void addGoal(Player player, Match match) {
        Goal goal = new Goal(player, match);
        goalService.save(goal);

        if (player.getTeam() == match.getGuest()) {
            matchService.addGuestsGoals(match);
        } else {
            matchService.addHostsGoals(match);
        }
    }

    public void finishMatch(Match match) {

        if (match.getGuestsGoals() > match.getHostsGoals()) {
            addScoreToStanding(match.getGuest(),match.getYear(),3);
        }else if (match.getGuestsGoals() < match.getHostsGoals()){
            addScoreToStanding(match.getHost(),match.getYear(),3);
        }else {
            addScoreToStanding(match.getGuest(),match.getYear(),1);
            addScoreToStanding(match.getHost(),match.getYear(),1);
        }
    }


    public void showMustGoalsInDerby(Year year){
        System.out.println(matchService.findMustGoalsInDerby(year));
    }


    private static Ranking addScoreToStanding(Team team , Year year, int score){
        Ranking ranking = new Ranking();
        Optional<Ranking> optionalStanding = RANKING_SERVICE.findByTeamAndYear(team, year);
        if (optionalStanding.isPresent()){
             ranking = optionalStanding.get();
            ranking.addTotalScore(score);
        }
        return ranking;
    }





}
