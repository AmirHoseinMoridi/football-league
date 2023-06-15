package Service.Coach.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Coach;
import Entity.Team;
import Repository.City.CityRepository;
import Repository.Coach.CoachRepository;
import Service.City.CityService;
import Service.Coach.CoachService;

public class CoachServiceImpl
        extends BaseServiceImpl<Coach, CoachRepository>
        implements CoachService {


    public CoachServiceImpl(CoachRepository repository) {
        super(repository);
    }

    @Override
    public Coach findByTeam(Team team) {
        return repository.findByTeam(team);
    }
}
