package com.javamachine.javamachine.service;

import java.util.List;
import java.util.Optional;

import com.javamachine.javamachine.model.ProductModel;

public interface ProductService {

    public List<ProductModel> getAllProduct(int page, int size);

    public Optional<ProductModel> getProductById(long productId);

    public void deleteProduct(long productId);

    public ProductModel addProduct(ProductModel product);

    public ProductModel updateProduct(ProductModel product);

}