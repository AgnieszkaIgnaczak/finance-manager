package org.example.service;

import org.example.entity.Category;
import org.example.entity.Income;
import org.example.untils.ConnectionManager;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class IncomeService {

    //walidacja

    public boolean incomeValidation(double income) {
        if (income > 0) {
            return true;
        }
        return false;
    }

    //dodanie przychodu, daty i komentarza

    public void insertIncome(double incomeAmount, String incomeComment) {
        boolean result = incomeValidation(incomeAmount);
        if (result == true) {
            Income income = new Income(incomeAmount);
            income.setIncomeComment(incomeComment);
            income.setIncomeDate(LocalDate.now());
            Session session = ConnectionManager.getSession();
            session.getTransaction().begin();
            session.persist(income);
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<Income> displayAllIncome() {
        Session session = ConnectionManager.getSession();
        List<Income> incomes1 = session.createQuery("select i from Income i").getResultList();
        session.close();
        return incomes1;

    }

    //walidacja

    public boolean incomeDeletionValidation(int incomeId) {
        if (incomeId > 0) {
            return true;
        }
        return false;
    }

    //usuwanie przychodu

    public void removeIncome(int incomeId) {
        boolean result = incomeDeletionValidation(incomeId);
        if (result == true) {
            Session session = ConnectionManager.getSession();
            session.getTransaction().begin();
            session.createQuery("delete from Income i where i.id=:id")
                    .setParameter("id", incomeId).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
    }


}



