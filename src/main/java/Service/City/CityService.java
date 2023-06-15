package Service.City;

import Base.Service.BaseService;
import Entity.City;

import java.util.Optional;

public interface CityService
        extends BaseService<City> {
    Optional<City> findByName(String name);
}
