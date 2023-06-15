package Service.Person;

import Base.Service.BaseService;
import Entity.Person;

import java.util.Optional;

public interface PersonService
        extends BaseService<Person> {
    Optional<Person> findByName(String name);

}
