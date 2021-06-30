package com.example.springbootdatajpaquerydsl.product;

import com.example.springbootdatajpaquerydsl.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, updatable = false)
    private Long id;

    private String name;

//    @JsonBackReference
    @JsonIgnoreProperties({"products"})
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }

    private String description;

    private int price;

    private String manufacturer;

    private int unitInStock;

    @Builder
    public Product(String name, Category category, String description, int price, String manufacturer, int unitInStock) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.unitInStock = unitInStock;
    }
}
