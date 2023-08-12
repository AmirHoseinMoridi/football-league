package Service.Player;

import Base.Service.BaseService;
import Entity.Player;
import Entity.Team;
import Service.Person.PersonService;

import java.util.List;

public interface PlayerService
        extends PersonService<Player> {
    List<Player> findByTeam(Team team);
}
