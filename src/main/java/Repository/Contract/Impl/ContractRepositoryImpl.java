package Repository.Contract.Impl;

import Base.Repositoy.Impl.BaseRepositoryImpl;
import Entity.Contract;
import Entity.Person;
import Entity.Team;
import Repository.Contract.ContractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.Year;
import java.util.List;

public class ContractRepositoryImpl
        extends BaseRepositoryImpl<Contract>
        implements ContractRepository {

    public ContractRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Contract> getEntityClass() {
        return Contract.class;
    }

    @Override
    public List<Contract> findByYear(Year year) {
        String hql = """
                select c from Contract c where c.year = :year
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("year", year);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByTeam(Team team) {
        String hql = """
                select c from Contract c where c.team = :team
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("team", team);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByTeam(Team team, Year year) {
        String hql = """
                select c from Contract c where c.team = :team and c.year = :year
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("team", team)
                .setParameter("year", year);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByPerson(Person person) {
        String hql = """
                select c from Contract c where c.person = :person
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("person", person);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByPerson(Person person, Year year) {
        String hql = """
                select c from Contract c where c.person = :person and c.year = :year
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("person", person)
                .setParameter("year", year);

        return typedQuery.getResultList();
    }



    @Override
    public List<Contract> findHigherPrice() {
        //
        String hql = """
                select c from Contract c order by c.price desc
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass());

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findHigherPrice(Year year) {
        String hql = """
                select c from Contract c where c.year = :year order by c.price desc
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter("year",year);

        return typedQuery.getResultList();
    }
}
