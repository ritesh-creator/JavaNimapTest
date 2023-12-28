package com.javamachine.javamachine.Implservice;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javamachine.javamachine.dao.CategoryDao;
import com.javamachine.javamachine.dao.ProductDao;
import com.javamachine.javamachine.model.CategoryModel;
import com.javamachine.javamachine.model.ProductModel;
import com.javamachine.javamachine.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    // List<CategoryModel> list;

    @Override
    public List<CategoryModel> getAllCategory(int page, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid page size: " + size);
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<CategoryModel> categoryPage = categoryDao.findAll(pageable);
        return categoryPage.getContent();
    }
    @Override
    public Optional<CategoryModel> getCategoryById(long categoryId) {
        return categoryDao.findById(categoryId);
    }
    @Override
    public CategoryModel addCategory(CategoryModel category) {
        // list.add(category);
        categoryDao.save(category);
        return category;
    }
    @Override
    public CategoryModel updateCategory(CategoryModel category) {
        categoryDao.save(category);
        return category;
    }
    @Override
    public void deleteCategory(long categoryId) {
        categoryDao.findById(categoryId);
        categoryDao.deleteById(categoryId);
    }
    @Override
    public Page<ProductModel> getAllProductsByCategoryIdWithPagination(Long categoryId, int page, int size) {
        CategoryModel category = categoryDao.findById(categoryId).orElse(null);
        if (category != null) {
            Pageable pageable = (Pageable) PageRequest.of(page, size);
            return productDao.findByCategory(category, pageable);
        }
        return Page.empty();
    }

}
