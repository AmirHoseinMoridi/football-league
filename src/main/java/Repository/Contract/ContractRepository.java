package Repository.Contract;

import Base.Repositoy.BaseRepository;
import Entity.Contract;
import Entity.Person;
import Entity.Team;

import java.time.Year;
import java.util.List;

public interface ContractRepository extends BaseRepository<Contract> {
    List<Contract> findByYear(Year year);

    List<Contract> findByTeam(Team team);

    List<Contract> findByTeam(Team team, Year year);

    List<Contract> findByPerson(Person person);

    List<Contract> findByPerson(Person person, Year year);

    Contract findHigherPrice();

    Contract findHigherPrice(Year year);

}
