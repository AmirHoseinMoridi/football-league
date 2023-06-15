package Operation;

import Entity.*;
import Repository.Goal.Impl.GoalRepositoryImpl;
import Repository.Match.Impl.MatchRepositoryImpl;
import Repository.Standing.Impl.StandingRepositoryImpl;
import Service.Goal.GoalService;
import Service.Goal.Impl.GoalServiceImpl;
import Service.Match.Impl.MatchServiceImpl;
import Service.Match.MatchService;
import Service.Standing.Impl.StandingServiceImpl;
import Service.Standing.StandingService;
import Util.config.JpaUtil;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarEntry;

public class MatchOperation {

    MatchService matchService = new MatchServiceImpl(new MatchRepositoryImpl(JpaUtil.getEntityManager()));

    private final GoalService goalService = new GoalServiceImpl(new GoalRepositoryImpl(JpaUtil.getEntityManager()));

    private final StandingService standingService = new StandingServiceImpl(new StandingRepositoryImpl(JpaUtil.getEntityManager()));

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
            Team winner = match.getGuest();
            Year yearOfMatch = match.getYear();
            Optional<Standing> optionalStanding = standingService.findByTeamAndYear(winner, yearOfMatch);
            if (optionalStanding.isPresent()){
                Standing standing = optionalStanding.get();
                standing.addTotalScore(3);
            }


        }
    }


}
