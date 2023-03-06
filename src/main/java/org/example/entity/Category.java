package org.example.entity;

//encja to klasa, która jest zmapowana na tabelę DB
//pakiet entity = model
//a DTO to klasa, która służy do przesyłania danych pomiędzy warstwami / modułami
//a DAO => klasy z sufixem dao, a nie repository

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category") // nazwa pola po przeciwnej stronie
    private List<Expense> expenses;

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
