package com.javamachine.javamachine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javamachine.javamachine.model.ProductModel;
import com.javamachine.javamachine.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductModel> getAllProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        return productService.getAllProduct(page, size);
    }

    @GetMapping("/product/{productId}")
    public Optional<ProductModel> getProductById(@PathVariable String productId) {
        return this.productService.getProductById(Long.parseLong(productId));
    }

    @PostMapping("/product")
    public ProductModel addProduct(@RequestBody ProductModel product) {
        return this.productService.addProduct(product);
    }

    @PutMapping("/product/{productId}")
    public ProductModel updateProduct(@RequestBody ProductModel product) {
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable String productId) {
        try {
            this.productService.deleteProduct(Long.parseLong(productId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
