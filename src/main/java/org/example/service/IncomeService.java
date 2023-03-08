package org.example.service;

import org.example.entity.Income;
import org.example.untils.ConnectionManager;
import org.hibernate.Session;

import java.time.LocalDate;

public class IncomeService {

    public boolean incomeValidation(Double income) {
        if(income > 0) {
            return true;
        }
        return false;
    }

    public boolean incomeCommentValidation(String incomeComment) {
        if(incomeComment == null) {
            return false;
        }
        return true;
    }

    public void insertIncome(double incomeAmount) {
        boolean result = incomeValidation(incomeAmount);
        if (result == true) {
            Income income = new Income(incomeAmount);
            Session session = ConnectionManager.getSession();
            session.getTransaction().begin();
            session.persist(incomeAmount);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void insertComment(String incomeComment) {
        boolean result = incomeCommentValidation(incomeComment);
        if (result == true) {
            Income income = new Income(incomeComment);
            Session session = ConnectionManager.getSession();
            session.getTransaction().begin();
            session.persist(incomeComment);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void insertDate(LocalDate incomeDate) {
        Session session = ConnectionManager.getSession();
        session.getTransaction().begin();
        session.persist(incomeDate);
        session.getTransaction().commit();
        session.close();
    }



}
