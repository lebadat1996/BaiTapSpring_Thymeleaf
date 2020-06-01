package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class productService implements IProductService {

    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "IPhone 1", " Phone", "black"));
        productMap.put(2, new Product(2, "IPhone 2", " Phone", "blue"));
        productMap.put(3, new Product(3, "IPhone 3", " Phone", "yellow"));
        productMap.put(4, new Product(4, "IPhone 4", " Phone", "white"));
        productMap.put(5, new Product(5, "IPhone 5", " Phone", "brow"));
        productMap.put(6, new Product(6, "IPhone 6", " Phone", "orange"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void Save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product getProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }
}
