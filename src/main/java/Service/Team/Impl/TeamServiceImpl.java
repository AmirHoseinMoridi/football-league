package Service.Team.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.City;
import Entity.Team;
import Repository.Team.TeamRepository;
import Service.Team.TeamService;

import java.util.List;
import java.util.Optional;

public class TeamServiceImpl
        extends BaseServiceImpl<Team, TeamRepository>
        implements TeamService {
    public TeamServiceImpl(TeamRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Team> findByName(String name) {
        try {
            return repository.findByName(name);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public List<Team> findByCity(City city) {
        return repository.findByCity(city);
    }
}
