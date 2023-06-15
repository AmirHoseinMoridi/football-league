package Repository;

import Base.Repositoy.BaseRepository;
import Entity.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends BaseRepository<City> {

    Optional<City> findByName(String name);

}
