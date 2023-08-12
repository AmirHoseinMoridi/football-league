package Service.Coach.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Coach;
import Entity.Team;
import Repository.City.CityRepository;
import Repository.Coach.CoachRepository;
import Service.City.CityService;
import Service.Coach.CoachService;
import Service.Person.Impl.PersonServiceImpl;

public class CoachServiceImpl
        extends PersonServiceImpl<Coach,CoachRepository>
        implements CoachService {


    public CoachServiceImpl(CoachRepository repository) {
        super(repository);
    }

    @Override
    public Coach findByTeam(Team team) {
        return repository.findByTeam(team);
    }
}
