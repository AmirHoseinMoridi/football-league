package Repository.Person.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Person;
import Repository.Person.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class PersonRepositoryImpl
        extends BaseRepositoryImpl<Person>
        implements PersonRepository {
    public PersonRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Optional<Person> findByName(String name) {
        String jpql = """
                select p from Person p where p.name = :n
                """;
        TypedQuery<Person> typedQuery = em.createQuery(jpql, this.getEntityClass()).setParameter(Person.NAME, name);

        return Optional.ofNullable(typedQuery.getSingleResult());
    }
}
