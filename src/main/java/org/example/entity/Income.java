package org.example.entity;

//reprezentacja tabeli income w MySQL

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "income")
@NoArgsConstructor // konstruktor bezparametrowy
@Data //gettery i settery, toString, hashCode, equals
public class Income {

    //pola reprezentujące kolumny w tabeli
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int incomeId;

    @Column(name = "amount")
    private double incomeAmount;

    @Column(name = "entry_date")
    private LocalDate incomeDate;

    @Column(name = "comment_expense")
    private String incomeComment;

    public Income(int incomeId, double incomeAmount, LocalDate incomeDate, String incomeComment) {
        this.incomeId = incomeId;
        this.incomeAmount = incomeAmount;
        this.incomeDate = incomeDate;
        this.incomeComment = incomeComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Income income = (Income) o;

        return incomeId == income.incomeId;
    }

    @Override
    public int hashCode() {
        return incomeId;
    }
}
