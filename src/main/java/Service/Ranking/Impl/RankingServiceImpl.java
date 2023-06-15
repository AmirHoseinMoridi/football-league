package Service.Ranking.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Ranking;
import Entity.Team;
import Repository.Ranking.RankingRepository;
import Service.Ranking.RankingService;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public class RankingServiceImpl
        extends BaseServiceImpl<Ranking, RankingRepository>
        implements RankingService {
    public RankingServiceImpl(RankingRepository repository) {
        super(repository);
    }

    @Override
    public List<Ranking> findByTeam(Team team) {
        return repository.findByTeam(team);
    }

    @Override
    public List<Ranking> findByYear(Year year) {
        return repository.findByYear(year);
    }

    @Override
    public Optional<Ranking> findByTeamAndYear(Team team, Year year) {
        try {
            return repository.findByTeamAndYear(team,year);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Ranking ChampionOfYear(Year year) {
        return repository.ChampionOfYear(year);
    }

    @Override
    public void addTotalScore(Ranking ranking, int score) {
        transaction.begin();
        repository.addTotalScore(ranking,score);
        transaction.commit();
    }
}
