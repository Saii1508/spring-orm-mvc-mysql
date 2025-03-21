package com.spring.mvc.service;

import com.spring.mvc.dao.ProductsDao;
import com.spring.mvc.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductsDao productsDao;

    @Transactional
    public void saveProduct(Products products) {
        productsDao.addProduct(products);
                                                                                                 }

    @Transactional
    public List<Products> getProducts() {
        return productsDao.getAllProducts();
    }

    @Transactional
    public void removeProduct(int id) {
        productsDao.removeProduct(id);
    }

    @Transactional
    public Products getOneProduct(int id) {
        return productsDao.getProduct(id);
    }

    /*@Transactional
    public void updateProduct(Products products) {
        productsDao.updateProduct(products);
    }*/

}
