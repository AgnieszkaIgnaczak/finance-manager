package org.example.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Data
public class Expense {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int expenseId;

    @Column(name = "amount")
    private double expenseAmount;

    @Column(name = "entry_date")
    private LocalDate expenseDate;

    @Column(name = "comment_expense")
    private String expenseComment;

    public Expense() {

    }

    public Expense(int expenseId, double expenseAmount, LocalDate expenseDate, String expenseComment) {
        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.expenseComment = expenseComment;
    }
}
