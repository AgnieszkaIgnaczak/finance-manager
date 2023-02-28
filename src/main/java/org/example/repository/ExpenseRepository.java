package org.example.repository;

import org.example.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends Repository<Expense> {

    @Override
    default Expense save(Expense expense) {
        return null;
    }

    @Override
    default List<Expense> getAll() {
        return null;
    }

    @Override
    default Optional<Expense> getById(int id) {
        return Optional.empty();
    }

    @Override
    default Expense update(Expense expense) {
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
