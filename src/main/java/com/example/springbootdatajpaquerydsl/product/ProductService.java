package com.example.springbootdatajpaquerydsl.product;

import com.example.springbootdatajpaquerydsl.category.Category;
import com.example.springbootdatajpaquerydsl.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    public void removeProduct(Long id) {
        Product _product = productRepository.findById(id).get();
        Category _category = _product.getCategory();
        _category.getProducts().remove(_product);
        categoryRepository.save(_category);
    }
}
