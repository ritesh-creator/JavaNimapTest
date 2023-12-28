package com.javamachine.javamachine.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ProductModel> products;

    public CategoryModel(Long categoryId, String categoryName, String description) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    public CategoryModel() {
        super();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryModel [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description="
                + description + ", getCategoryId()=" + getCategoryId() + ", getCategoryName()=" + getCategoryName()
                + ", getDescription()=" + getDescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
