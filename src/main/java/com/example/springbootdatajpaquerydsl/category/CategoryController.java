package com.example.springbootdatajpaquerydsl.category;

import com.example.springbootdatajpaquerydsl.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category _category = categoryService.addCategory(category);
        return new ResponseEntity<>(_category, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category _category = categoryService.updateCategory(category);
        return new ResponseEntity<>(_category, HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        categoryService.removeCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
