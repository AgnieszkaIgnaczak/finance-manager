package org.example.entity;

//encja to klasa, która jest zmapowana na tabelę DB
//a DTO to klasa, która służy do przesyłania danych pomiędzy warstwami / modułami
//a DAO => klasy z sufixem dao, a nie repository

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category") // nazwa pola po przeciwnej stronie
    private Expense expense;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return categoryId == category.categoryId;
    }

    @Override
    public int hashCode() {
        return categoryId;
    }
}
