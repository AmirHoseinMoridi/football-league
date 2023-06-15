package Service.Goal;

import Base.Service.BaseService;
import Entity.Goal;
import Entity.Match;
import Entity.Player;

import java.util.List;

public interface GoalService
        extends BaseService<Goal> {
    List<Goal> findByPlayer(Player player);

    List<Goal> findByPlayerInMatch(Player player, Match match);

    List<Goal> findByMatch(Match match);
}
