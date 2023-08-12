package Repository.Stadium.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.City;
import Entity.Stadium;
import Repository.Stadium.StadiumRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class StadiumRepositoryImpl
        extends BaseRepositoryImpl<Stadium>
        implements StadiumRepository {
    public StadiumRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Stadium> getEntityClass() {
        return Stadium.class;
    }

    @Override
    public Optional<Stadium> findByName(String name) {

        String hql = """
                select s from Stadium s where s.name = :name
                """;
        TypedQuery<Stadium> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("name", name);

        return Optional.ofNullable(typedQuery.getSingleResult());
    }

    @Override
    public List<Stadium> findByCity(City city) {
        String hql = """
                select s from Stadium s where s.city = :city
                """;
        TypedQuery<Stadium> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("city", city);

        return typedQuery.getResultList();
    }
}
