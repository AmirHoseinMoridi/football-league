package Repository.Player;

import Base.Repositoy.BaseRepository;
import Entity.Person;
import Entity.Player;
import Entity.Team;
import Repository.Person.PersonRepository;

import java.util.List;

public interface PlayerRepository extends PersonRepository<Player> {
    List<Player> findByTeam(Team team);
}
