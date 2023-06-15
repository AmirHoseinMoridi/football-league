package Operation;

import Entity.Coach;
import Entity.Player;
import Repository.Player.Impl.PlayerRepositoryImpl;
import Service.Player.Impl.PlayerServiceImpl;
import Service.Player.PlayerService;
import Util.config.JpaUtil;

import javax.naming.Name;

public class PlayerOperation {

    private final PlayerService playerService = new PlayerServiceImpl(new PlayerRepositoryImpl(JpaUtil.getEntityManager()));


    public void add(String name) {
        Player player = new Player();
        player.setName(name);
        playerService.save(player);
    }
}
