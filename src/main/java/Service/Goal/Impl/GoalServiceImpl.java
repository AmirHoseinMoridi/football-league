package Service.Goal.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Goal;
import Entity.Match;
import Entity.Player;
import Repository.Goal.GoalRepository;
import Service.Goal.GoalService;

import java.util.List;

public class GoalServiceImpl
        extends BaseServiceImpl<Goal, GoalRepository>
        implements GoalService {
    public GoalServiceImpl(GoalRepository repository) {
        super(repository);
    }

    @Override
    public List<Goal> findByPlayer(Player player) {
        return repository.findByPlayer(player);
    }

    @Override
    public List<Goal> findByPlayerInMatch(Player player, Match match) {
        return repository.findByPlayerInMatch(player,match);
    }

    @Override
    public List<Goal> findByMatch(Match match) {
        return repository.findByMatch(match);
    }
}
