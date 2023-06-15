package Service.Standing;

import Base.Service.BaseService;
import Entity.Standing;
import Entity.Team;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface StandingService
        extends BaseService<Standing> {
    List<Standing> findByTeam(Team team);

    List<Standing> findByYear(Year year);

    Optional<Standing> findByTeamAndYear(Team team, Year year);

    void addTotalScore(Standing standing,int score);
}
