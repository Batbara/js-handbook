package by.bsuir.talakh.repository;

import java.util.List;
import java.util.Optional;

public interface EntityRepository<T> {
    List<T> takeAll();

    Optional<T> findById(int id);

    Optional<T> findByName(String name);

    T save(T entity);

    void deleteById(int id);

    void update(int id, T entity);
}
