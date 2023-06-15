package Operation;

import Entity.City;
import Entity.Coach;
import Entity.Person;
import Repository.City.Impl.CityRepositoryImpl;
import Repository.Coach.Impl.CoachRepositoryImpl;
import Service.City.CityService;
import Service.City.Impl.CityServiceImpl;
import Service.Coach.CoachService;
import Service.Coach.Impl.CoachServiceImpl;
import Util.config.JpaUtil;

public class CoachOperation {
    private final CoachService coachService = new CoachServiceImpl(new CoachRepositoryImpl(JpaUtil.getEntityManager()));



    public void add(String name) {
        Coach coach = new Coach();
        coach.setName(name);
        coachService.save(coach);
    }



}
