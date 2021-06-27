package com.example.springbootdatajpaquerydsl.product;

import com.example.springbootdatajpaquerydsl.category.Category;
import com.example.springbootdatajpaquerydsl.category.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setup() {
        List<Product> products = new ArrayList<>();

        for(int i=0;i<10;i++) {
            Category category = Category.builder()
                    .name("category" + i)
                    .build();

            Product product = Product.builder()
                    .name("product"+i)
                    .category(category)
                    .description("Best Prodcut!")
                    .price(1000)
                    .manufacturer("Apple")
                    .unitInStock(10)
                    .build();
            products.add(product);
        }

        productRepository.saveAll(products);
    }

    @AfterEach
    void cleanAll() {
        productRepository.deleteAll();
    }

    @Test
    public void 전체_product_조회시_10을_리턴() {
        //given
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        //then
        assertThat(products.size(), is(10));
        assertThat(categories.size(), is(10));
    }
}
