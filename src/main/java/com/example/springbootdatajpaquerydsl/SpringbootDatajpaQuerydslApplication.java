package com.example.springbootdatajpaquerydsl;

import com.example.springbootdatajpaquerydsl.domain.category.CategoryRepository;
import com.example.springbootdatajpaquerydsl.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringbootDatajpaQuerydslApplication implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatajpaQuerydslApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Category category = Category.builder()
//                .name("notebook")
//                .build();
//        categoryRepository.save(category);
//
//        Set<Product> products = new HashSet<>();
//        for(int i=0;i<10;i++) {
//            products.add(Product.builder()
//                    .name("macbook" + i)
//                    .price(1000)
//                    .category(category)
//                    .description("it's best notebook")
//                    .manufacturer("apple")
//                    .unitInStock(10)
//                    .build());
//        }
//
//        productRepository.saveAll(products);
    }
}
