package com.example.springbootdatajpaquerydsl.domain.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        List<Product> products = new ArrayList<>();

        for(int i=0;i<10;i++) {
            Product product = Product.builder()
                    .name("product"+i)
                    .description("Best Prodcut!")
                    .category(null)
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
    @DisplayName("전체_product_조회시_10_리턴")
    public void findAllTest() {
        //given
        List<Product> products = productRepository.findAll();

        //then
        assertThat(products.size(), is(10));
    }

    @Test
    public void querydsl_Custom설정_기능_확인() {
        final int price = 100;
        for(int i=0;i<10;i++) {
            productRepository.save(Product.builder()
                    .name("TestProduct"+i)
                    .description("Best Prodcut!")
                    .category(null)
                    .price(price)
                    .manufacturer("Apple")
                    .unitInStock(10)
                    .build());
        }

        //when
        List<Product> result = productRepository.findByPrice(price);

        //then
        assertThat(result.size(), is(price));
        assertThat(result.get(0).getName(), is("TestProduct0"));
    }
}
