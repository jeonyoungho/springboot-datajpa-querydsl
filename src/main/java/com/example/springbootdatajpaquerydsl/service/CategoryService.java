package com.example.springbootdatajpaquerydsl.service;

import com.example.springbootdatajpaquerydsl.domain.category.Category;
import com.example.springbootdatajpaquerydsl.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
