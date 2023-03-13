package org.example.repository;

//defining the method, implementation
//implementacje metod z CategoryRepository

import org.example.entity.Category;
import org.example.untils.ConnectionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public Category save(Category category) {
        return CategoryRepository.super.save(category);
    }

    @Override
    public Optional<Category> getByName(String categoryName) {
        Session session = ConnectionManager.getSession();
        Query<Category> query = session.createQuery("select c from Category c where c.categoryName=:categoryName", Category.class).setParameter("categoryName", categoryName);
        Optional<Category> category = Optional.of(query.uniqueResult());
        session.close();
        return category;
    }


}
