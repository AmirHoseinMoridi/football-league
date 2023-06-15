package Repository.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Goal;
import Entity.Player;
import Entity.Team;
import Repository.PersonRepository;
import Repository.PlayerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlayerRepositoryImpl
        extends BaseRepositoryImpl<Player>
        implements PlayerRepository {
    public PlayerRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }

    @Override
    public List<Player> findByTeam(Team team) {
        String hql = """
                select p from Player p where p.team = :t
                """;
        TypedQuery<Player> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Player.TEAM, team);

        return typedQuery.getResultList();
    }
}
