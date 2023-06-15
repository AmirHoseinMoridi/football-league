package Operation;

import Entity.City;
import Repository.City.Impl.CityRepositoryImpl;
import Repository.Team.Impl.TeamRepositoryImpl;
import Service.City.CityService;
import Service.City.Impl.CityServiceImpl;
import Service.Team.Impl.TeamServiceImpl;
import Service.Team.TeamService;
import Util.config.JpaUtil;

import java.util.List;
import java.util.Optional;

public class CityOperation {
    private final CityService cityService = new CityServiceImpl(new CityRepositoryImpl(JpaUtil.getEntityManager()));
    private final TeamService teamService = new TeamServiceImpl(new TeamRepositoryImpl(JpaUtil.getEntityManager()));


    public boolean add(String name) {
        if (cityService.findByName(name).isPresent()) {
            return false;
        } else {
            City city = new City(name);
            cityService.save(city);
            return true;
        }
    }

    public void showAllWhitStadiums(){
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            System.out.println("city : " + city.getName());
            System.out.println("stadiums : ");
            System.out.println(teamService.findByCity(city));
        }
    }



}
