package Service.Stadium;

import Base.Service.BaseService;
import Entity.City;
import Entity.Stadium;

import java.util.List;
import java.util.Optional;

public interface StadiumService
        extends BaseService<Stadium> {
    Optional<Stadium> findByName(String name);

    List<Stadium> findByCity(City city);
}
