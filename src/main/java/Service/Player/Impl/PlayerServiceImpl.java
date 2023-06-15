package Service.Player.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Player;
import Entity.Team;
import Repository.Player.PlayerRepository;
import Service.Person.PersonService;
import Service.Player.PlayerService;

import java.util.List;

public class PlayerServiceImpl
        extends BaseServiceImpl<Player, PlayerRepository>
        implements PlayerService {
    public PlayerServiceImpl(PlayerRepository repository) {
        super(repository);
    }

    @Override
    public List<Player> findByTeam(Team team) {
        return repository.findByTeam(team);
    }
}
