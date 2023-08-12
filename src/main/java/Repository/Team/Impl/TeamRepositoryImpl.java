package Repository.Team.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.City;
import Entity.Team;
import Repository.Team.TeamRepository;
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
                select t from Team t where t.name = :name
                """;
        TypedQuery<Team> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("name", name);

        return Optional.ofNullable(typedQuery.getSingleResult());
    }

    @Override
    public List<Team> findByCity(City city) {
        String hql = """
                select t from Team t where t.city = :city
                """;
        TypedQuery<Team> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("city", city);

        return typedQuery.getResultList();
    }
}
