package com.javamachine.javamachine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.javamachine.javamachine.model.CategoryModel;
import com.javamachine.javamachine.model.ProductModel;

import com.javamachine.javamachine.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryModel> getAllCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        return categoryService.getAllCategory(page, size);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<CategoryModel> getCategoryById(@PathVariable Long categoryId) {
        return this.categoryService.getCategoryById(categoryId);
    }
    @PostMapping("/category")
    public CategoryModel addCategory(@RequestBody CategoryModel category) {
        return this.categoryService.addCategory(category);
    }
    @PutMapping("/category/{categoryId}")
    public CategoryModel updateCategory(@RequestBody CategoryModel category) {
        return this.categoryService.updateCategory(category);
    }
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable String categoryId) {
        try {
            this.categoryService.deleteCategory(Long.parseLong(categoryId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("{categoryId}/product")
    public Page<ProductModel> getAllProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size) {
        return categoryService.getAllProductsByCategoryIdWithPagination(categoryId, page, size);
    }

}
