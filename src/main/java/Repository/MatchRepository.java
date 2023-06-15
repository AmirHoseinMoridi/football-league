package Repository;

import Base.Repositoy.BaseRepository;
import Entity.Match;
import Entity.Team;

import java.util.List;

public interface MatchRepository extends BaseRepository<Match> {
    List<Match> findByTeam(Team team);
}
