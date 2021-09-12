package com.example.springbootdatajpaquerydsl.domain.category;

import com.example.springbootdatajpaquerydsl.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(nullable = false, updatable = false)
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
