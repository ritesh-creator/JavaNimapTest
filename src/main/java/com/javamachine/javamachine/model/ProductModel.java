package com.javamachine.javamachine.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private BigDecimal productCost;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryModel category;

    public ProductModel(Long productId, String productName, BigDecimal productCost, String description) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.description = description;
    }

    public ProductModel() {
        super();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductModel [productId=" + productId + ", productName=" + productName + ", description=" + description
                + ", getProductId()=" + getProductId() + ", getProductName()=" + getProductName()
                + ", getDescription()=" + getDescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
