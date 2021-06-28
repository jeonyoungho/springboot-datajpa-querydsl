package com.example.springbootdatajpaquerydsl.category;

import com.example.springbootdatajpaquerydsl.product.Product;
import com.example.springbootdatajpaquerydsl.product.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setup() {
        Set<Product> products = new LinkedHashSet<>();
        for(int i=0;i<10;i++) {
            Product product = Product.builder()
                    .name("product"+i)
                    .description("Best Prodcut!")
                    .price(1000)
                    .manufacturer("Apple")
                    .unitInStock(10)
                    .build();
            products.add(product);
        }

        Category category = Category.builder()
                .name("category1")
                .products(products)
                .build();
        categoryRepository.save(category);
    }

    @AfterEach
    void cleanAll() {
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("전체_product_조회시_10_리턴")
    public void findAllTest() {
        //given
        List<Product> products = productRepository.findAll();
        Category category = categoryRepository.findById(1L).get();

        //then
        assertThat(category.getProducts().size(), is(10));
        assertThat(products.size(), is(10));
    }
}
