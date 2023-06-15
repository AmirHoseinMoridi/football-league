package Service.Match.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Base.Service.Impl.BaseServiceImpl;
import Entity.Match;
import Entity.Team;
import Repository.Match.MatchRepository;
import Service.Match.MatchService;

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
}
