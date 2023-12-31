package Service.Match.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Base.Service.Impl.BaseServiceImpl;
import Entity.Match;
import Entity.Team;
import Repository.Match.MatchRepository;
import Service.Match.MatchService;

import java.time.Year;
import java.util.List;

public class MatchServiceImpl
        extends BaseServiceImpl<Match, MatchRepository>
        implements MatchService {
    public MatchServiceImpl(MatchRepository repository) {
        super(repository);
    }

    @Override
    public List<Match> findByTeam(Team team) {
        return repository.findByTeam(team);
    }

    @Override
    public Match findMustGoalsInDerby(Year year) {
        return repository.findMustGoalsInDerby(year);
    }

    @Override
    public void addGuestsGoals(Match match) {
        match.addGuestsGoals();
        transaction.begin();
        repository.addGuestsGoals(match);
        transaction.commit();
    }

    @Override
    public void addHostsGoals(Match match) {
        transaction.begin();
        repository.addHostsGoals(match);
        transaction.commit();
    }
}
