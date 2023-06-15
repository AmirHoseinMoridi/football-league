package Repository.Standing;

import Base.Repositoy.BaseRepository;
import Entity.Standing;
import Entity.Team;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface StandingRepository extends BaseRepository<Standing> {
    List<Standing> findByTeam(Team team);

    List<Standing> findByYear(Year year);
    Optional<Standing> findByTeamAndYear(Team team, Year year);

    void addTotalScore(Standing standing,int score);
}
