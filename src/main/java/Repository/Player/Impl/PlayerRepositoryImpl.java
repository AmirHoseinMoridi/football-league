package Repository.Player.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Player;
import Entity.Team;
import Repository.Person.Impl.PersonRepositoryImpl;
import Repository.Player.PlayerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlayerRepositoryImpl
        extends PersonRepositoryImpl<Player>
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
                select p from Player p where p.team = :team
                """;
        TypedQuery<Player> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("team", team);

        return typedQuery.getResultList();
    }
}
