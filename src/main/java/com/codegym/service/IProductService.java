package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void Save(Product product);

    Product getProductById(int id);

    void update(int id, Product product);

    void delete(int id);
}
