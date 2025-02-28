package com.spring.mvc.dao;

import com.spring.mvc.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addProduct(Products products) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.saveOrUpdate(products);
        transaction.commit();
    }

    @Transactional
    public List<Products> getAllProducts() {
        Session session = sessionFactory.openSession();
        String query = "FROM Products";
        Query<Products> setQuery = session.createQuery(query, Products.class);
        return setQuery.stream().toList();
    }

    @Transactional
    public void removeProduct(int id) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Products products = session.get(Products.class, id);
            if (products != null) {
                session.delete(products); // Delete the product if found
                transaction.commit(); // Commit the transaction
            } else {
                System.out.println("Product not found with ID: " + id); // Log if not found
            }
        } finally {
            session.close(); // Always close the session after the transaction
        }
    }

    @Transactional
    public Products getProduct(int id) {
        Session session = sessionFactory.openSession();
        Products products = session.get(Products.class,id);
        return products;
    }
}

  /*  @Transactional
    public void updateProduct(Products products) {
        Session session = sessionFactory.openSession();
        Products product = session.get(Products.class,products.getId());
        product.setName(products.getName());
        product.setDescription(products.getDescription());
        product.setPrice(products.getPrice());
        session.update(product);
    }*/


