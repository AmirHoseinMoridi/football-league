package Service.Match;

import Base.Service.BaseService;
import Entity.Match;
import Entity.Team;

import java.util.List;

public interface MatchService
        extends BaseService<Match> {
    List<Match> findByTeam(Team team);
    void addGuestsGoals(Match match);
    void addHostsGoals(Match match);
}
