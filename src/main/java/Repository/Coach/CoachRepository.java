package Repository.Coach;

import Base.Repositoy.BaseRepository;
import Entity.Coach;
import Entity.Team;

public interface CoachRepository extends BaseRepository<Coach> {
    Coach findByTeam(Team team);
}
