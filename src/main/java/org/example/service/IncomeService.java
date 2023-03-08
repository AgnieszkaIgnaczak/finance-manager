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

}
