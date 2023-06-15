package Repository.Standing;

import Base.Repositoy.BaseRepository;
import Entity.Standing;
import Entity.Team;

import java.time.Year;
import java.util.List;

public interface StandingRepository extends BaseRepository<Standing> {
    List<Standing> findByTeam(Team team);

    List<Standing> findByYear(Year year);
}
