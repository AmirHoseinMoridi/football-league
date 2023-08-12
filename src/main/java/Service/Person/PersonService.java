package Service.Person;

import Base.Service.BaseService;
import Entity.Person;

import java.util.Optional;

public interface PersonService<P extends Person>
        extends BaseService<P> {
    Optional<P> findByName(String name);

}
