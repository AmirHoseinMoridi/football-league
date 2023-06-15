package Base.Repositoy;

import Base.Entity.BaseEntity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> {

    void save(E e);

    void update(E e);

    void delete(E e);

    Optional<E> findById(Long id);

    List<E> findAll();

}
