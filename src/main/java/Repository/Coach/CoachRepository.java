package Repository.Coach;

import Base.Repositoy.BaseRepository;
import Entity.Coach;
import Entity.Team;
import Repository.Person.PersonRepository;

public interface CoachRepository extends PersonRepository<Coach> {
    Coach findByTeam(Team team);
}
