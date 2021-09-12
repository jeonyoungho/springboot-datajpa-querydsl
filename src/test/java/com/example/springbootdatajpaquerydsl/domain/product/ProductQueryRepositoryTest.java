package com.example.springbootdatajpaquerydsl.domain.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductQueryRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductQueryRepository productQueryRepository;

    @AfterEach
    public void tearDown() throws Exception {
        productRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기본_기능_확인2() {
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
        List<Product> result = productQueryRepository.findByPrice(price);

        //then
        assertThat(result.size(), is(price));
        assertThat(result.get(0).getName(), is("TestProduct0"));
    }
}
