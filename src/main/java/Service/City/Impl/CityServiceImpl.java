package Service.City.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.City;
import Repository.City.CityRepository;
import Service.City.CityService;

import java.util.Optional;

public class CityServiceImpl
        extends BaseServiceImpl<City, CityRepository>
        implements CityService {

    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }

    @Override
    public Optional<City> findByName(String name) {
        try {
            return repository.findByName(name);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
