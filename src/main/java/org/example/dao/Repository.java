package org.example.dao;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    T save(T t); //method add()

    List<T> getAll();

    Optional<T> getById(int id);

    T update(T t);

    boolean removeById(int id);

    boolean removeAll();
}
