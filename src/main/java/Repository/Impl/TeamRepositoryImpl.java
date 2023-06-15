package Repository.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.City;
import Entity.Team;
import Repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class TeamRepositoryImpl
        extends BaseRepositoryImpl<Team>
        implements TeamRepository {
    public TeamRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }

    @Override
    public Optional<Team> findByName(String name) {
        String hql = """
                select t from Team t where t.name = :n
                """;
        TypedQuery<Team> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Team.NAME, name);

        return Optional.ofNullable(typedQuery.getSingleResult());
    }

    @Override
    public List<Team> findByCity(City city) {
        String hql = """
                select t from Team t where t.city = :c
                """;
        TypedQuery<Team> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Team.CITY, city);

        return typedQuery.getResultList();
    }
}
