package org.example.repository;

//defining the method, implementation
//implementacje metod z CategoryRepository

import org.example.entity.Category;
import java.util.LinkedList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public Category save(Category category) {
        return CategoryRepository.super.save(category);
    }
}
