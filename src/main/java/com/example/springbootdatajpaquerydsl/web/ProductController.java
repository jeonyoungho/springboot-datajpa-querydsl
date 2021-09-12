package com.example.springbootdatajpaquerydsl.web;

import com.example.springbootdatajpaquerydsl.domain.product.Product;
import com.example.springbootdatajpaquerydsl.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product _product = productService.addProduct(product);
        return new ResponseEntity<>(_product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product _product = productService.updateProduct(product);
        return new ResponseEntity<>(_product, HttpStatus.OK);
    }

    @PutMapping("/products2")
    public ResponseEntity<Void> updateProduct2() {
//        Product _product = productService.updateProduct(product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.removeProduct(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
