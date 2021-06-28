package com.example.springbootdatajpaquerydsl.category;

import com.example.springbootdatajpaquerydsl.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void removeCategory(Long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }


}
