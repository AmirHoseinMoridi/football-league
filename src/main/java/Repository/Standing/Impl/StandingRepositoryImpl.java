package Repository.Standing.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Standing;
import Entity.Team;
import Repository.Standing.StandingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.Year;
import java.util.List;

public class StandingRepositoryImpl
        extends BaseRepositoryImpl<Standing>
        implements StandingRepository {
    public StandingRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Standing> getEntityClass() {
        return Standing.class;
    }

    @Override
    public List<Standing> findByTeam(Team team) {
        String hql = """
                select s from Standing s where s.team = :t
                """;
        TypedQuery<Standing> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Standing.TEAM, team);

        return typedQuery.getResultList();
    }

    @Override
    public List<Standing> findByYear(Year year) {
        String hql = """
                select s from Standing s where s.year = :y
                """;
        TypedQuery<Standing> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Standing.YEAR, year);

        return typedQuery.getResultList();
    }
}
