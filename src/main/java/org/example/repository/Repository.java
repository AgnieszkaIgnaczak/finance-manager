package org.example.repository;

//Repository - interfejs generyczny ogólny, który zbiera wspólne metody dla wszystkich tabel -
//tutaj trzeba się w przyszłości zastanowić czy wszystkie metody będą potrzebne

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
