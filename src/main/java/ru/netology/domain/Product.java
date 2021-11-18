package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Product {
    private int id;
    private String name;
    private int price;

    public boolean matches(String search) {
        return this.name.equalsIgnoreCase(search);
    }
}
