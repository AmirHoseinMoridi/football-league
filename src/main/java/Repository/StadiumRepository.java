package Repository;

import Base.Repositoy.BaseRepository;
import Entity.City;
import Entity.Stadium;

import java.util.List;
import java.util.Optional;

public interface StadiumRepository extends BaseRepository<Stadium> {
    Optional<Stadium> findByName(String name);

    List<Stadium> findByCity(City city);
}
