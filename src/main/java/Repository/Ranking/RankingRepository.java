package Repository.Ranking;

import Base.Repositoy.BaseRepository;
import Entity.Ranking;
import Entity.Team;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface RankingRepository extends BaseRepository<Ranking> {
    List<Ranking> findByTeam(Team team);

    List<Ranking> findByYear(Year year);
    Optional<Ranking> findByTeamAndYear(Team team, Year year);

    Ranking ChampionOfYear(Year year);

    void addTotalScore(Ranking ranking, int score);
}
