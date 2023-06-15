package Repository.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Contract;
import Entity.Goal;
import Entity.Match;
import Entity.Player;
import Repository.GoalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GoalRepositoryImpl
        extends BaseRepositoryImpl<Goal>
        implements GoalRepository {

    public GoalRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Goal> getEntityClass() {
        return Goal.class;
    }

    @Override
    public List<Goal> findByPlayer(Player player) {
        String hql = """
                select g from Goal g where g.player = :p
                """;
        TypedQuery<Goal> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Goal.PLAYER, player);

        return typedQuery.getResultList();
    }

    @Override
    public List<Goal> findByPlayerInMatch(Player player, Match match) {
        String hql = """
                select g from Goal g where g.player = :p and g.match = :m
                """;
        TypedQuery<Goal> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Goal.PLAYER, player)
                .setParameter(Goal.MATCH, match);

        return typedQuery.getResultList();
    }

    @Override
    public List<Goal> findByMatch(Match match) {
        String hql = """
                select g from Goal g where g.match = :m
                """;
        TypedQuery<Goal> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Goal.MATCH, match);

        return typedQuery.getResultList();
    }
}
