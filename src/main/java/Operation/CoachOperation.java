package Operation;


import Entity.Coach;
import Repository.Coach.Impl.CoachRepositoryImpl;
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
