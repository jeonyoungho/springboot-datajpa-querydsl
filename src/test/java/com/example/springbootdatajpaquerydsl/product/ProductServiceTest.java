package com.example.springbootdatajpaquerydsl.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        List<Product> products = new ArrayList<>();

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

        productRepository.saveAll(products);
    }

    @AfterEach
    void cleanAll() {
        productRepository.deleteAll();
    }

    @Test
    public void 전체_product_조회시_10을_리턴() {
        //given
        List<Product> products = productService.getProducts();

        //then
        assertThat(products.size(), is(10));
    }
}
