package Service.Contract;

import Base.Service.BaseService;
import Entity.Contract;
import Entity.Person;
import Entity.Team;

import java.time.Year;
import java.util.List;

public interface ContractService
        extends BaseService<Contract> {
    List<Contract> findByYear(Year year);

    List<Contract> findByTeam(Team team);

    List<Contract> findByTeam(Team team, Year year);

    List<Contract> findByPerson(Person person);

    List<Contract> findByPerson(Person person, Year year);

    List<Contract> findHigherPrice();

    List<Contract> findHigherPrice(Year year);
}
