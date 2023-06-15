package Service.Standing.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Standing;
import Entity.Team;
import Repository.Standing.StandingRepository;
import Service.Standing.StandingService;

import java.time.Year;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Standing> findByTeamAndYear(Team team, Year year) {
        try {
            return repository.findByTeamAndYear(team,year);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public void addTotalScore(Standing standing, int score) {
        transaction.begin();
        repository.addTotalScore(standing,score);
        transaction.commit();
    }
}
