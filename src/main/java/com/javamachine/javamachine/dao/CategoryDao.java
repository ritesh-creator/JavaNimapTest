package com.javamachine.javamachine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamachine.javamachine.model.CategoryModel;

public interface CategoryDao extends JpaRepository<CategoryModel, Long> {

}