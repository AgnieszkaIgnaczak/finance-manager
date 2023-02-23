package org.example.dao;

import org.example.dto.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends Repository<Category> {

    @Override
    default Category save(Category category) {
        return null;
    }

    @Override
    default List<Category> getAll() {
        return null;
    }

    @Override
    default Optional<Category> getById(int id) {
        return Optional.empty();
    }

    @Override
    default Category update(Category category) {
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
