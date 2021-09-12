package com.example.springbootdatajpaquerydsl.domain.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.springbootdatajpaquerydsl.domain.product.QProduct.product;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ProductRepositorySupport(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }

    public List<Product> findByPrice(int price) {
        return queryFactory
                .selectFrom(product)
                .where(product.price.eq(price))
                .fetch();
    }
}
