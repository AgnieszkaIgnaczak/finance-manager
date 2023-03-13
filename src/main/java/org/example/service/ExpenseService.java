package org.example.service;

import org.example.entity.Category;
import org.example.entity.Expense;
import org.example.repository.ExpenseRepository;
import org.example.untils.ConnectionManager;
import org.hibernate.Session;

import java.time.LocalDate;

public class ExpenseService {

    private final CategoryService categoryService;
    private final ExpenseRepository expenseRepository;

    public ExpenseService(CategoryService categoryService, ExpenseRepository expenseRepository) {
        this.categoryService = categoryService;
        this.expenseRepository = expenseRepository;
    }

    //walidacja

    public boolean expenseValidation(double expense) {
        if (expense > 0) {
            return true;
        }
        return false;
    }

    //dodanie wydatku

    public void insertExpense(double expenseAmount, String expenseDecision, String enteredExpenseCategory) {
        boolean result = expenseValidation(expenseAmount);
        Category category = categoryService.findCategory(enteredExpenseCategory);
        if (result == true && category != null) {
            Expense expense = new Expense(expenseAmount);
            expense.setCategory(category);
            expense.setExpenseComment(expenseDecision);
            expense.setExpenseDate(LocalDate.now());
            expenseRepository.save(expense);

        }
    }
}
