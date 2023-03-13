package org.example.repository;

import org.example.entity.Expense;
import org.example.untils.ConnectionManager;
import org.hibernate.Session;

public class ExpenseRepositoryImpl implements ExpenseRepository {

    @Override
    public Expense save(Expense expense) {
        Session session = ConnectionManager.getSession();
        session.getTransaction().begin();
        Expense merge = session.merge(expense);
        session.getTransaction().commit();
        session.close();
        return merge;
    }
}
