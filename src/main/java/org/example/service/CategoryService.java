package org.example.service;

import org.example.entity.Category;
import org.example.untils.ConnectionManager;
import org.hibernate.Session;

public class CategoryService {

    public boolean categoryValidation(String category) {
        if(category.isEmpty() == false) {
            return true;
        }
        return false;
    }

    public void create(String categoryName) {
        boolean result = categoryValidation(categoryName);
        if (result == true) {
            Category category = new Category(categoryName);
            Session session = ConnectionManager.getSession();
            session.getTransaction().begin();
            session.persist(category);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void remove(String categoryNameRemove) {
        boolean result = categoryValidation(categoryNameRemove);
        if (result == true) {
            Category category = new Category(categoryNameRemove);
            Session session = ConnectionManager.getSession();
            session.getTransaction().begin();
            session.remove(category);
            session.getTransaction().commit();
            session.close();
        }
    }
}
