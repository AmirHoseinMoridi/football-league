package Repository.Team;

import Base.Repositoy.BaseRepository;
import Entity.City;
import Entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends BaseRepository<Team> {
    Optional<Team> findByName(String name);

    List<Team> findByCity(City city);
}
