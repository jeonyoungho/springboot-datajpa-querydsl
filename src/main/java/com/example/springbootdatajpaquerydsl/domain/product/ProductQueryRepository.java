package com.example.springbootdatajpaquerydsl.domain.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.springbootdatajpaquerydsl.domain.product.QProduct.product;

@RequiredArgsConstructor
@Repository
public class ProductQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Product> findByPrice(int price) {
        return queryFactory
                .selectFrom(product)
                .where(product.price.eq(price))
                .fetch();
    }
}
