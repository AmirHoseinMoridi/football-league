package Service.Coach;

import Base.Service.BaseService;
import Entity.Coach;
import Entity.Team;
import Service.Person.PersonService;

public interface CoachService
        extends PersonService<Coach> {
    Coach findByTeam(Team team);
}
