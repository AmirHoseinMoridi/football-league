package Service.Player;

import Base.Service.BaseService;
import Entity.Player;
import Entity.Team;

import java.util.List;

public interface PlayerService
        extends BaseService<Player> {
    List<Player> findByTeam(Team team);
}
