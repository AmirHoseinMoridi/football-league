package Service.Stadium.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.City;
import Entity.Stadium;
import Repository.Stadium.StadiumRepository;
import Service.Stadium.StadiumService;

import java.util.List;
import java.util.Optional;

public class StadiumServiceImpl
        extends BaseServiceImpl<Stadium, StadiumRepository>
        implements StadiumService {
    public StadiumServiceImpl(StadiumRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Stadium> findByName(String name) {
        try {
            return repository.findByName(name);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public List<Stadium> findByCity(City city) {
        return repository.findByCity(city);
    }
}
