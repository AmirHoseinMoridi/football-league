package Repository.Person.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Person;
import Repository.Person.PersonRepository;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public abstract class PersonRepositoryImpl<P extends Person>
        extends BaseRepositoryImpl<P>
        implements PersonRepository<P> {
    public PersonRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<P> findByName(String name) {
        String jpql = "select p from" + getEntityClass().getSimpleName() + " p where p.name = :name";


        return Optional.ofNullable(
                em.createQuery(jpql, getEntityClass())
                        .setParameter("name", name)
                        .getSingleResult()
        );
    }
}
