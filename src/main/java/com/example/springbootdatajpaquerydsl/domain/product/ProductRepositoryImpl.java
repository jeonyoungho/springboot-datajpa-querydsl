package com.example.springbootdatajpaquerydsl.domain.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.springbootdatajpaquerydsl.domain.product.QProduct.product;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Product> findByPrice(int price) {
        return queryFactory
                .selectFrom(product)
                .where(product.price.eq(price))
                .fetch();
    }
}
