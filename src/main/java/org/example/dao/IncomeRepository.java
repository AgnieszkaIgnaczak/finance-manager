package org.example.dao;

import org.example.dto.Income;

import java.sql.SQLException;
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
