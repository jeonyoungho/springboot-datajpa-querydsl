package com.example.springbootdatajpaquerydsl.category;

import com.example.springbootdatajpaquerydsl.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false, updatable = false)
    private Long id;

    private String name;

//    @JsonManagedReference
    @JsonIgnoreProperties({"category"})
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new LinkedHashSet<>();

    @Builder
    public Category(String name, Set<Product> products) {
        this.name = name;
        if(products != null) {
            this.products = products;
        }
    }
}
