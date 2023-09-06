package org.example.dao;

import org.example.entity.Product;

import java.util.List;

public interface ProductDao {

    public void saveProduct(Product product);

    public List<Product> findAllProducts();
}
