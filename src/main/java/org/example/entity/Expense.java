package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Data
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int expenseId;

    @Column(name = "amount")
    private double expenseAmount;

    @Column(name = "entry_date")
    private LocalDate expenseDate;

    @Column(name = "comment_expense")
    private String expenseComment;

    @ManyToOne
    @JoinColumn(name = "category_id") //klucz obcy z MySQL
    private Category category;

    public Expense(int expenseId, double expenseAmount, LocalDate expenseDate, String expenseComment) {
        this.expenseId = expenseId;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.expenseComment = expenseComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        return expenseId == expense.expenseId;
    }

    @Override
    public int hashCode() {
        return expenseId;
    }
}
