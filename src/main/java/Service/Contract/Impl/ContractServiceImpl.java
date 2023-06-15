package Service.Contract.Impl;

import Base.Service.Impl.BaseServiceImpl;
import Entity.Contract;
import Entity.Person;
import Entity.Team;
import Repository.Contract.ContractRepository;
import Service.Coach.CoachService;
import Service.Contract.ContractService;

import java.time.Year;
import java.util.List;

public class ContractServiceImpl
        extends BaseServiceImpl<Contract, ContractRepository>
        implements ContractService {

    public ContractServiceImpl(ContractRepository repository) {
        super(repository);
    }

    @Override
    public List<Contract> findByYear(Year year) {
        return repository.findByYear(year);
    }

    @Override
    public List<Contract> findByTeam(Team team) {
        return repository.findByTeam(team);
    }

    @Override
    public List<Contract> findByTeam(Team team, Year year) {
        return repository.findByTeam(team,year);
    }

    @Override
    public List<Contract> findByPerson(Person person) {
        return repository.findByPerson(person);
    }

    @Override
    public List<Contract> findByPerson(Person person, Year year) {
        return repository.findByPerson(person,year);
    }

    @Override
    public Contract findHigherPrice() {
        return repository.findHigherPrice();
    }

    @Override
    public Contract findHigherPrice(Year year) {
        return repository.findHigherPrice(year);
    }
}
