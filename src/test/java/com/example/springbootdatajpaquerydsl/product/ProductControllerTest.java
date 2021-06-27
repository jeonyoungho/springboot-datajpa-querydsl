package com.example.springbootdatajpaquerydsl.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("전체 Product 리스트 조회 테스트")
    void getProductListTest() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder()
                .name("product")
                .description("Best Prodcut!")
                .price(1000)
                .manufacturer("Apple")
                .unitInStock(10)
                .build());

        given(productService.getProducts()).willReturn(products);

        mvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Best")));
    }

    @Test
    @DisplayName("id로 특정 Product 조회 테스트")
    void getProductByIdTest() throws Exception {
        Product product = Product.builder()
                .name("macbook_pro")
                .description("Best Product")
                .price(1000)
                .manufacturer("Apple")
                .unitInStock(10)
                .build();

        given(productService.getProductById(1L)).willReturn(product);

        mvc.perform(get("/api/v1/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("macbook_pro")))
                .andExpect(jsonPath("$.description", is("Best Product")))
                .andExpect(jsonPath("$.price", is(1000)))
                .andExpect(jsonPath("$.manufacturer", is("Apple")))
                .andExpect(jsonPath("$.unitInStock", is(10)));
        }
}
