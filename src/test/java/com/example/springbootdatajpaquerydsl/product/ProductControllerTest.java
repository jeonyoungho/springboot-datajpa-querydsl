package com.example.springbootdatajpaquerydsl.product;

import com.example.springbootdatajpaquerydsl.category.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("단일 Product 삽입 테스트")
    void addProductTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Product product = Product.builder()
                .name("macbook_pro")
                .description("Best Product!")
                .price(1000)
                .manufacturer("Apple")
                .unitInStock(10)
                .build();

        given(productService.addProduct(any())).willReturn(product);

        mvc.perform(post("/api/v1/products")
                .content(objectMapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("macbook_pro")))
                .andExpect(jsonPath("$.description", is("Best Product!")))
                .andExpect(jsonPath("$.price", is(1000)))
                .andExpect(jsonPath("$.manufacturer", is("Apple")))
                .andExpect(jsonPath("$.unitInStock", is(10)));
    }

    @Test
    @DisplayName("Post 메소드 example")
    void example() throws Exception {
        String text = "test message";
        mvc.perform(post("/api/v1/products/example")
        .content(text))
                .andExpect(status().isOk())
                .andExpect(content().string(text));
    }

    @Test
    @DisplayName("전체 Product 리스트 조회 테스트")
    void getProductsTest() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder()
                .name("macbook_pro")
                .description("Best Product!")
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
