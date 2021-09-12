package com.example.springbootdatajpaquerydsl.domain.product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByPrice(int price);
}
