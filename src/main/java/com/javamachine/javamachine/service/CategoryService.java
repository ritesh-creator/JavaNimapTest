package com.javamachine.javamachine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.javamachine.javamachine.model.CategoryModel;
import com.javamachine.javamachine.model.ProductModel;

public interface CategoryService {

    public List<CategoryModel> getAllCategory(int page, int size);

    public Optional<CategoryModel> getCategoryById(long categoryId);

    public CategoryModel addCategory(CategoryModel category);

    public void deleteCategory(long categoryId);

    public CategoryModel updateCategory(CategoryModel category);

    Page<ProductModel> getAllProductsByCategoryIdWithPagination(Long categoryId, int page, int size);

}
