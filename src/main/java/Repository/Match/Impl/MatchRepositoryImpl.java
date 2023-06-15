package Repository.Match.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Match;
import Entity.Team;
import Repository.Match.MatchRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.Year;
import java.util.List;

public class MatchRepositoryImpl
        extends BaseRepositoryImpl<Match>
        implements MatchRepository {
    public MatchRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Match> getEntityClass() {
        return Match.class;
    }

    @Override
    public List<Match> findByTeam(Team team) {
        String hql = """
                select m from Match m where m.guest = :t or m.host = :t
                """;
        TypedQuery<Match> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Match.GUEST, team)
                .setParameter(Match.HOST, team);

        return typedQuery.getResultList();
    }

    @Override
    public Match findMustGoalsInDerby(Year year) {
        String hql = """
                select m from Match m where m.year = :y 
                and m.guest.city = m.host.city and (m.guestsGoals + m.hostsGoals) =
                (select max (m.hostsGoals + m.guestsGoals) from Match m)
                """;
        TypedQuery<Match> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Match.YEAR,year);

        return typedQuery.getSingleResult();
    }

    @Override
    public void addGuestsGoals(Match match) {
        match.addGuestsGoals();
        em.merge(match);
    }

    @Override
    public void addHostsGoals(Match match) {
        match.addHostsGoals();
        em.merge(match);
    }


}
