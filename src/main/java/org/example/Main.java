package org.example;

import org.example.dto.Category;
import org.example.dto.Expense;
import org.example.dto.Income;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello Finance Manager!");

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Expense.class);
        configuration.addAnnotatedClass(Income.class);

    }
}