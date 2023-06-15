package Base.Service.Impl;

import Base.Entity.BaseEntity;
import Base.Repositoy.BaseRepository;
import Base.Service.BaseService;
import Util.config.JpaUtil;
import jakarta.persistence.EntityTransaction;


import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository<E>> implements BaseService<E> {
    protected final R repository;
    protected final EntityTransaction transaction;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
        transaction = JpaUtil.getEntityManager().getTransaction();
    }

    @Override
    public E save(E e) {
        transaction.begin();
        repository.save(e);
        transaction.commit();
        return e;
    }

    @Override
    public E update(E e) {
        transaction.begin();
        repository.update(e);
        transaction.commit();
        return e;
    }

    @Override
    public void delete(E e) {
        transaction.begin();
        repository.delete(e);
        transaction.commit();
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

}
