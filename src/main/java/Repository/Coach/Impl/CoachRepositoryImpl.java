package Repository.Coach.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Coach;
import Entity.Team;
import Repository.Coach.CoachRepository;
import Repository.Person.Impl.PersonRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CoachRepositoryImpl
        extends PersonRepositoryImpl<Coach>
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
                select c from Coach c where c.team = :team
                """;
        TypedQuery<Coach> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("team", team);

        return typedQuery.getSingleResult();
    }
}
