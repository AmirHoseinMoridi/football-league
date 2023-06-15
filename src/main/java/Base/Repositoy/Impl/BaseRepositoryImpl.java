package Base.Repositoy.Impl;

import Base.Entity.BaseEntity;
import Base.Repositoy.BaseRepository;
import Util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {
    protected final EntityManager em;

    public BaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(E e) {
        em.persist(e);
    }

    @Override
    public void update(E e) {
        em.merge(e);
    }

    @Override
    public void delete(E e) {
        em.remove(e);
    }

    @Override
    public Optional<E> findById(Long id) {
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    @Override
    public List<E> findAll() {
        return em.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass())
                .getResultList();
    }


    public abstract Class<E> getEntityClass();
}
