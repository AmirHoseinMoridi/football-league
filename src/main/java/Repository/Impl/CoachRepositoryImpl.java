package Repository.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.City;
import Entity.Coach;
import Entity.Goal;
import Entity.Team;
import Repository.CoachRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CoachRepositoryImpl
        extends BaseRepositoryImpl<Coach>
        implements CoachRepository {
    public CoachRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }

    @Override
    public Coach findByTeam(Team team) {
        String hql = """
                select c from Coach c where c.team = :t
                """;
        TypedQuery<Coach> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Coach.TEAM, team);

        return typedQuery.getSingleResult();
    }
}
