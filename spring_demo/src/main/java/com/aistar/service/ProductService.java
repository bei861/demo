package com.aistar.service;

import com.aistar.pojo.Product;

import java.util.List;

public interface ProductService {
    public boolean add(Product product);
    public boolean update(Product product);
    public boolean delete(String proId);
    public Product getById(String proId);
    public List<Product> getAll();
    public boolean updateScore(Product p1, Product p2);
}
