package by.bsuir.talakh.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> takeAll();

    Optional<T> findById(int id);

    Optional<T> findByName(String name);

    T save(T entity);

    void deleteById(int id);

    void update(int id, T entity);
}
