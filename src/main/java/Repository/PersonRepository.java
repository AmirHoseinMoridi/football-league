package Repository;

import Base.Repositoy.BaseRepository;
import Entity.City;
import Entity.Person;

import java.util.Optional;

public interface PersonRepository extends BaseRepository<Person> {
    Optional<Person> findByName(String name);


}
