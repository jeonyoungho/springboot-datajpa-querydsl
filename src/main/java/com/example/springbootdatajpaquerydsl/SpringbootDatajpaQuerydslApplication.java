package com.example.springbootdatajpaquerydsl;

import com.example.springbootdatajpaquerydsl.category.Category;
import com.example.springbootdatajpaquerydsl.product.Product;
import com.example.springbootdatajpaquerydsl.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringbootDatajpaQuerydslApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatajpaQuerydslApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = Category.builder()
                .name("notebook")
                .build();

        List<Product> products = new ArrayList<>();

        for(int i=0;i<10;i++) {
            products.add(Product.builder()
                    .name("macbook" + i)
                    .category(category)
                    .price(1000)
                    .description("it's best notebook")
                    .manufacturer("apple")
                    .unitInStock(10)
                    .build());
        }

        productRepository.saveAll(products);
    }
}
