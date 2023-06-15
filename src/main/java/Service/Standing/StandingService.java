package Service.Standing;

import Base.Service.BaseService;
import Entity.Standing;
import Entity.Team;

import java.time.Year;
import java.util.List;

public interface StandingService
        extends BaseService<Standing> {
    List<Standing> findByTeam(Team team);

    List<Standing> findByYear(Year year);
}
