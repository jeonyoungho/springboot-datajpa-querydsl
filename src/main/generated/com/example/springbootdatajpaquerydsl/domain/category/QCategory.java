package com.example.springbootdatajpaquerydsl.domain.category;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 867579516L;

    public static final QCategory category = new QCategory("category");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<com.example.springbootdatajpaquerydsl.domain.product.Product, com.example.springbootdatajpaquerydsl.domain.product.QProduct> products = this.<com.example.springbootdatajpaquerydsl.domain.product.Product, com.example.springbootdatajpaquerydsl.domain.product.QProduct>createSet("products", com.example.springbootdatajpaquerydsl.domain.product.Product.class, com.example.springbootdatajpaquerydsl.domain.product.QProduct.class, PathInits.DIRECT2);

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

