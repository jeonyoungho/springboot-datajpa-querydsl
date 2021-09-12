package com.example.springbootdatajpaquerydsl.domain.product;

import com.example.springbootdatajpaquerydsl.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

        productRepository.saveAll(products);
    }

    @AfterEach
    void cleanAll() {
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("전체_product_조회시_10_리턴")
    public void getProductsTest() {
        //given
        List<Product> products = productService.getProducts();

        //then
        assertThat(products.size(), is(10));
    }

    @Test
    @DisplayName("product_name으로_조회_테스트")
    public void getProductByNameTest() {
        //given
        String name = "product1";
        Product product = productService.getProductByName(name);

        //then
        assertThat(product.getName(), is(name));
    }

    @Test
    @DisplayName("product_삭제_테스트")
    public void removeProductTest() {
        //given
        boolean isRemoved = productService.removeProduct(11L);

        //then
        assertThat(isRemoved, is(true));
    }
}
