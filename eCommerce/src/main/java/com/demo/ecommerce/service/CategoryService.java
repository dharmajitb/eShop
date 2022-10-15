package com.demo.ecommerce.service;

import com.demo.ecommerce.model.Category;

import java.util.Set;

public interface CategoryService {

    public Category addProduct(Category category);
    public Category updateProduct(Category category);
    public Set<Category> getProduct();
    public Category getProduct(int id);
    public void deleteProduct(int id);
}
