package com.javamachine.javamachine.Implservice;

import com.javamachine.javamachine.service.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.javamachine.javamachine.dao.ProductDao;
import com.javamachine.javamachine.model.ProductModel;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    // List<CategoryModel> list;

    @Override
    public List<ProductModel> getAllProduct(int page, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid page size: " + size);
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductModel> productPage = productDao.findAll(pageable);
        return productPage.getContent();
    }
    @Override
    public Optional<ProductModel> getProductById(long productId) {
        return productDao.findById(productId);
    }

    @Override
    public ProductModel addProduct(ProductModel product) {
        // list.add(category);
        productDao.save(product);
        return product;
    }

    @Override
    public ProductModel updateProduct(ProductModel product) {
        productDao.save(product);
        return product;
    }

    @Override
    public void deleteProduct(long productId) {
        productDao.findById(productId);
        productDao.deleteById(productId);
    }

}
