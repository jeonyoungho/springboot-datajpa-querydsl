package com.example.springbootdatajpaquerydsl.product;

import com.example.springbootdatajpaquerydsl.category.Category;
import com.example.springbootdatajpaquerydsl.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    public boolean removeProduct(Long id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
