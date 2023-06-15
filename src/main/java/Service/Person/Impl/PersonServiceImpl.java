package Service.Person.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Person;
import Repository.Person.PersonRepository;
import Service.Person.PersonService;

import java.util.Optional;

public class PersonServiceImpl
        extends BaseServiceImpl<Person, PersonRepository>
        implements PersonService {
    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Person> findByName(String name) {
        try {
            return repository.findByName(name);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
