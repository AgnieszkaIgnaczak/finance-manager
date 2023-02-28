package org.example.repository;

//restricting generic interface Repository<T> to class Category
//between-interface
//jest rozszerzeniem interfejsu generycznego, w którym można dopisać szczegółowe metody charakterystyczne tylko dla encji Category
//np. coś w stylu findCategoriesInName(List<String> names)

import org.example.entity.Category;

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
