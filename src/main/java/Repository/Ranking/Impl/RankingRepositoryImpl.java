package Repository.Ranking.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Ranking;
import Entity.Team;
import Repository.Ranking.RankingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public class RankingRepositoryImpl
        extends BaseRepositoryImpl<Ranking>
        implements RankingRepository {
    public RankingRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Ranking> getEntityClass() {
        return Ranking.class;
    }

    @Override
    public List<Ranking> findByTeam(Team team) {
        String hql = """
                select s from Ranking s where s.team = :t
                """;
        TypedQuery<Ranking> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Ranking.TEAM, team);

        return typedQuery.getResultList();
    }

    @Override
    public List<Ranking> findByYear(Year year) {
        String hql = """
                select s from Ranking s where s.year = :y
                """;
        TypedQuery<Ranking> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("y", year);

        return typedQuery.getResultList();
    }

    @Override
    public Optional<Ranking> findByTeamAndYear(Team team, Year year) {
        String hql = """
                select s from Ranking s where s.team = :t and s.year = :y
                """;
        TypedQuery<Ranking> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Ranking.TEAM, year)
                .setParameter(Ranking.YEAR,year);

        return Optional.ofNullable(typedQuery.getSingleResult()) ;
    }

    @Override
    public Ranking ChampionOfYear(Year year) {
        String hql = """
                select s from Ranking s where s.year = :y and s.totalScore = 
                (select max (s.totalScore) from Ranking s group by s.year)
                """;
        TypedQuery<Ranking> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("y",year);

        return typedQuery.getSingleResult();
    }

    @Override
    public void addTotalScore(Ranking ranking, int score) {
        ranking.addTotalScore(score);
        em.merge(ranking);
    }
}
