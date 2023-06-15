package Repository;

import Base.Repositoy.BaseRepository;
import Entity.Goal;
import Entity.Match;
import Entity.Player;

import java.util.List;

public interface GoalRepository extends BaseRepository<Goal> {

    List<Goal> findByPlayer(Player player);

    List<Goal> findByPlayerInMatch(Player player, Match match);

    List<Goal> findByMatch(Match match);
}
