package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Finance Manager!");
        System.out.println("");
        System.out.println("Tasks:");
        System.out.println("");
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
        String userEntry1 = scanner.nextLine();


    }
}