package Operation;

import Entity.*;
import Repository.Coach.Impl.CoachRepositoryImpl;
import Repository.Contract.Impl.ContractRepositoryImpl;
import Repository.Person.Impl.PersonRepositoryImpl;
import Repository.Player.Impl.PlayerRepositoryImpl;
import Service.Coach.CoachService;
import Service.Coach.Impl.CoachServiceImpl;
import Service.Contract.ContractService;
import Service.Contract.Impl.ContractServiceImpl;
import Service.Person.Impl.PersonServiceImpl;
import Service.Person.PersonService;
import Service.Player.Impl.PlayerServiceImpl;
import Service.Player.PlayerService;
import Util.config.JpaUtil;

import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.jar.JarEntry;

public class ContractOperation {

    private final ContractService contractService = new ContractServiceImpl(
            new ContractRepositoryImpl(JpaUtil.getEntityManager()));

    private final CoachService coachService = new CoachServiceImpl(
            new CoachRepositoryImpl(JpaUtil.getEntityManager()));

    private final PlayerService playerService = new PlayerServiceImpl(
            new PlayerRepositoryImpl(JpaUtil.getEntityManager()));

    public void add(Double price, Year year, Team team, Person person) {
        Contract contract = new Contract();
        contract.setPrice(price);
        contract.setYear(year);
        contract.setTeam(team);

        if (person instanceof Coach coach) {
            contract.setPerson(coach);
            contractService.save(contract);
            if (Objects.equals(year, Year.now())) {
                coach.setTeam(team);
                coachService.update(coach);
            }

        } else if (person instanceof Player player) {
            contract.setPerson(player);
            if (Objects.equals(year, Year.now())) {
                player.setTeam(team);
                playerService.update(player);
            }
        } else {
            System.out.println("this person is not exist");
        }
    }


    public void showHigherPriceOfCoaches() {

        List<Contract> contracts = contractService.findHigherPrice();
        Contract contract = firstCoachInList(contracts);
        System.out.println("name : " + contract.getPerson().getName() + " price : " + contract.getPrice());

    }

    public void showHigherPriceOfPlayers() {

        List<Contract> contracts = contractService.findHigherPrice();
        Contract contract = firstPlayerInList(contracts);
        System.out.println("name : " + contract.getPerson().getName() + " price : " + contract.getPrice());
    }

    public void showHigherPriceOfCoachesInYear(Year year) {
        List<Contract> contracts = contractService.findHigherPrice(year);
        Contract contract = firstCoachInList(contracts);
        System.out.println("name : " + contract.getPerson().getName() + " price : " + contract.getPrice());
    }

    public void showHigherPriceOfPlayersInYear(Year year) {
        List<Contract> contracts = contractService.findHigherPrice(year);
        Contract contract = firstPlayerInList(contracts);
        System.out.println("name : " + contract.getPerson().getName() + " price : " + contract.getPrice());
    }


    private static Contract firstCoachInList(List<Contract> contracts) {
        for (Contract contract : contracts) {
            Person person = contract.getPerson();
            if (person instanceof Coach) {
                return contract;
            }
        }
        return new Contract();
    }

    private static Contract firstPlayerInList(List<Contract> contracts) {
        for (Contract contract : contracts) {
            Person person = contract.getPerson();
            if (person instanceof Player) {
                return contract;
            }
        }
        return new Contract();
    }


}
