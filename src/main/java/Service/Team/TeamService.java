package Service.Team;

import Base.Service.BaseService;
import Entity.City;
import Entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService
        extends BaseService<Team> {
    Optional<Team> findByName(String name);

    List<Team> findByCity(City city);
}
