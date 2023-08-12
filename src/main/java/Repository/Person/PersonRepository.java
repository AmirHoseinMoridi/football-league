package Repository.Person;

import Base.Repositoy.BaseRepository;
import Entity.City;
import Entity.Person;

import java.util.Optional;

public interface PersonRepository<P extends Person> extends BaseRepository<P> {
    Optional<P> findByName(String name);
}
