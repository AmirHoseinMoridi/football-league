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
                select c from Contract c where c.year = :y
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Contract.YEAR, year);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByTeam(Team team) {
        String hql = """
                select c from Contract c where c.team = :t
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Contract.TEAM, team);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByTeam(Team team, Year year) {
        String hql = """
                select c from Contract c where c.team = :t and c.year = :y
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Contract.TEAM, team)
                .setParameter(Contract.YEAR, year);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByPerson(Person person) {
        String hql = """
                select c from Contract c where c.person = :p
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Contract.PERSON, person);

        return typedQuery.getResultList();
    }

    @Override
    public List<Contract> findByPerson(Person person, Year year) {
        String hql = """
                select c from Contract c where c.person = :p and c.year = :y
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Contract.PERSON, person)
                .setParameter(Contract.YEAR, year);

        return typedQuery.getResultList();
    }

    @Override
    public Contract findHigherPrice() {
        String hql = """
                select c from Contract c where c.price = (select max (c.price) from Contract c)
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass());

        return typedQuery.getSingleResult();
    }

    @Override
    public Contract findHigherPrice(Year year) {
        String hql = """
                select c from Contract c where c.year = :y and c.price = (select max (c.price) from Contract c)
                """;
        TypedQuery<Contract> typedQuery = em.createQuery(hql, this.getEntityClass())
                .setParameter(Contract.YEAR, year);

        return typedQuery.getSingleResult();
    }
}
