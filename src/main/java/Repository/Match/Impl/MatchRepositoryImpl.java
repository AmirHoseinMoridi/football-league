package Repository.Match.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Match;
import Entity.Team;
import Repository.Match.MatchRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
}
