package com.javamachine.javamachine.dao;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javamachine.javamachine.model.CategoryModel;
import com.javamachine.javamachine.model.ProductModel;

public interface ProductDao extends JpaRepository<ProductModel, Long> {
    Page<ProductModel> findByCategory(CategoryModel category, Pageable pageable);
}
