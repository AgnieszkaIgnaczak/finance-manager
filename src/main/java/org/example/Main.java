package org.example;

import org.example.entity.Income;
import org.example.repository.CategoryRepository;
import org.example.repository.CategoryRepositoryImpl;
import org.example.repository.ExpenseRepository;
import org.example.repository.ExpenseRepositoryImpl;
import org.example.service.CategoryService;
import org.example.service.ExpenseService;
import org.example.service.IncomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static final CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    private static final ExpenseRepository expenseRepository = new ExpenseRepositoryImpl();

    private static final CategoryService categoryService = new CategoryService(categoryRepository);
    private static final IncomeService incomeService = new IncomeService();

    private static final ExpenseService expenseService = new ExpenseService(categoryService, expenseRepository);

    public static void main(String[] args) {


        System.out.println("Hello Finance Manager!");
        System.out.println("");

        List<String> categories;

        while (true) {

            System.out.println("Tasks:");
            System.out.println("");
            System.out.println("0. Exit the program.");
            System.out.println("1. Add new expense.");
            System.out.println("2. Add new income.");
            System.out.println("3. Remove expense.");
            System.out.println("4. Remove income.");
            System.out.println("5. Display all income and expenses");
            System.out.println("6. Display all expenses.");
            System.out.println("7. Display expenses based on date range.");
            System.out.println("8. Display all expenses based on chosen category.");
            System.out.println("9. Display sum of expenses and their amount in each category.");
            System.out.println("10. Display all income.");
            System.out.println("11. Show the balance.");
            System.out.println("12. Add new category.");
            System.out.println("13. Remove category.");

            Scanner scanner = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Please choose task:");
            int userTaskNumber = 0;

            try {
                userTaskNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.error(e.toString());
                System.out.println("Not a number!");
                userTaskNumber = Integer.MAX_VALUE; // not from range 0-13 (task nr)
            } catch (NoSuchElementException e) {
                logger.error(e.toString());
                System.out.println("Have you entered anything?");
                userTaskNumber = Integer.MAX_VALUE; // not from range 0-13 (task nr)
            }
            //3rd type of exception IllegalStateException is considered as severe - program has to be closed

            switch (userTaskNumber) {
                case 0:
                    System.out.println("User closed the program.");
                    System.exit(1);
                case 1:
                    scanner.nextLine();
                    System.out.println("All categories:");
                    System.out.println(categoryService.getAllCategory().toString());
                    String enteredExpenseCategory = scanner.nextLine().toUpperCase();
                    System.out.println("Please add expense amount:");
                    double enteredExpense = scanner.nextDouble();

                    scanner.nextLine();
                    System.out.println("Do you want to add any comment to the provided expense amount? (optional: YES/NO)");

                    String expenseDecision = scanner.nextLine().toUpperCase();

                    String comment = null;

                    if(expenseDecision.equals("YES")) {
                        System.out.println("Please provide your comment here:");
                        comment = scanner.nextLine();
                    } else if (expenseDecision.equals("NO")) {
                        System.out.println("No comment added.");
                    } else {
                        System.out.println("Provided comment is incorrect.");
                    }

                    expenseService.insertExpense(enteredExpense, comment, enteredExpenseCategory);

                    break;
                case 2:
                    System.out.println("Please provide new income amount.");
                    double incomeAmount = scanner.nextDouble();
                    System.out.println("Provided income amount is " + incomeAmount + ".");

                    scanner.nextLine();
                    System.out.println("Do you want to add any comment to the provided income amount? (optional: YES/NO)");
                    String incomeDecision = scanner.nextLine().toUpperCase();
                    String incomeComment = null;
                    if(incomeDecision.equals("YES")) {
                        System.out.println("Please provide your comment here:");
                        incomeComment = scanner.nextLine();
                    } else if (incomeDecision.equals("NO")) {
                        System.out.println("No comment added.");
                    } else {
                        System.out.println("Provided comment is incorrect.");
                    }
                    incomeService.insertIncome(incomeAmount, incomeComment);

                    break;
                case 3:


                    break;
                case 4:
                    System.out.println("All income:");
                    List<Income> incomeList2 = incomeService.displayAllIncome();
                    System.out.println("Which category you want to delete:");
                    System.out.println(incomeList2.toString());
                    int incomeDeletionById = scanner.nextInt();

                    incomeService.removeIncome(incomeDeletionById);

                    break;
                case 5:
                    //instrukcje
                    break;
                case 6:
                    //instrukcje
                    break;
                case 7:
                    //instrukcje
                    break;
                case 8:
                    //instrukcje
                    break;
                case 9:
                    //instrukcje
                    break;
                case 10:
                    System.out.println("All income:");
                    List<Income> incomeList1 = incomeService.displayAllIncome();
                    System.out.println(incomeList1.toString());
                    break;
                case 11:
                    //instrukcje
                    break;
                case 12:
                    scanner.nextLine();
                    System.out.println("Please provide category name.");
                    String categoryName = scanner.nextLine().toUpperCase();
                    System.out.println("Provided category name is " + categoryName + ".");

                    categoryService.create(categoryName);

                    break;
                case 13:
                    scanner.nextLine();
                    System.out.println("Please provide category which you want to remove:");
                    categories = categoryService.getAllCategory();
                    System.out.println(categories.toString());
                    String categoryNameRemove = scanner.nextLine().toUpperCase();
                    System.out.println("Provided category to be removed is " + categoryNameRemove + ".");

                    categoryService.remove(categoryNameRemove);

                    break;
                default:
                    System.out.println("Task number does not exist. Please provide correct task number.");

            }
            System.out.println(" ");
            System.out.println("--------------------");
            System.out.println(" ");

        }

    }

}