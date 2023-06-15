package Operation;

import Entity.City;
import Entity.Stadium;
import Repository.Stadium.Impl.StadiumRepositoryImpl;
import Service.Stadium.Impl.StadiumServiceImpl;
import Service.Stadium.StadiumService;
import Util.config.JpaUtil;

public class StadiumOperation {
    private final StadiumService stadiumService =new StadiumServiceImpl(new StadiumRepositoryImpl(JpaUtil.getEntityManager()));


    public void add(String name, int capacity , City city){
        Stadium stadium = new Stadium(name, capacity, city);
        stadiumService.save(stadium);
    }
}
