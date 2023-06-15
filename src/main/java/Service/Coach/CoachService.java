package Service.Coach;

import Base.Service.BaseService;
import Entity.Coach;
import Entity.Team;

public interface CoachService
        extends BaseService<Coach> {
    Coach findByTeam(Team team);
}
