package org.example.service;

import org.example.dto.CategoryDto;
import org.example.entity.Category;
import org.example.untils.ConnectionManager;
import org.hibernate.Session;

import java.util.List;

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
            Session session = ConnectionManager.getSession();
            session.getTransaction().begin();
            session.createQuery("delete from Category c where c.categoryName=:categoryName")
                    .setParameter("categoryName", categoryNameRemove).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<String> getAllCategory() {
        Session session = ConnectionManager.getSession();
        List<String> categories1 = session.createQuery("select a.categoryName from Category a", String.class).getResultList();
        session.close();
        return categories1;
    }




}
