package org.example.repository;

import org.example.entity.Income;

import java.util.List;
import java.util.Optional;

public interface IncomeRepository extends Repository<Income> {

    @Override
    default Income save(Income income) {
        return null;
    }

    @Override
    default List<Income> getAll() {
        return null;
    }

    @Override
    default Optional<Income> getById(int id) {
        return Optional.empty();
    }

    @Override
    default Income update(Income income) {
        return null;
    }

    @Override
    default boolean removeById(int id) {
        return false;
    }

    @Override
    default boolean removeAll() {
        return false;
    }
}
