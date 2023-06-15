package Service.Standing.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Standing;
import Entity.Team;
import Repository.Standing.StandingRepository;
import Service.Standing.StandingService;

import java.time.Year;
import java.util.List;

public class StandingServiceImpl
        extends BaseServiceImpl<Standing, StandingRepository>
        implements StandingService {
    public StandingServiceImpl(StandingRepository repository) {
        super(repository);
    }

    @Override
    public List<Standing> findByTeam(Team team) {
        return repository.findByTeam(team);
    }

    @Override
    public List<Standing> findByYear(Year year) {
        return repository.findByYear(year);
    }
}
