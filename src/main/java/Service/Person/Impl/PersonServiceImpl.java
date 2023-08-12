package Service.Person.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Person;
import Repository.Person.PersonRepository;
import Service.Person.PersonService;

import java.util.Optional;

public class PersonServiceImpl<P extends Person , R extends PersonRepository<P>>
        extends BaseServiceImpl<P,R >
        implements PersonService<P> {
    public PersonServiceImpl(R repository) {
        super(repository);
    }

    @Override
    public Optional<P> findByName(String name) {
        try {
            return repository.findByName(name);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
