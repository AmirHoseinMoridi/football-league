package Repository.Match;

import Base.Repositoy.BaseRepository;
import Entity.Match;
import Entity.Team;

import java.time.Year;
import java.util.List;

public interface MatchRepository extends BaseRepository<Match> {
    List<Match> findByTeam(Team team);

    Match findMustGoalsInDerby(Year year);
    void addGuestsGoals(Match match);
    void addHostsGoals(Match match);
}
