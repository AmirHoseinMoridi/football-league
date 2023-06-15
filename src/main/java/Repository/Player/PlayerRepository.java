package Repository.Player;

import Base.Repositoy.BaseRepository;
import Entity.Player;
import Entity.Team;

import java.util.List;

public interface PlayerRepository extends BaseRepository<Player> {
    List<Player> findByTeam(Team team);
}
