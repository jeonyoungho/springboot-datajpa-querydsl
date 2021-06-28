package com.example.springbootdatajpaquerydsl.product;

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

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product _product = productService.updateProduct(product);
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

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product _product = productService.addProduct(product);
        return new ResponseEntity<>(_product, HttpStatus.OK);
    }

//    @PostMapping("/products")
//    public ResponseEntity<Product> addProduct() {
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }

    @PostMapping("/products/example")
    public ResponseEntity<String> example(@RequestBody String text) {
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.removeProduct(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
