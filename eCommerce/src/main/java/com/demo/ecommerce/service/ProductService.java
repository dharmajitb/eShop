package com.demo.ecommerce.service;

import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface ProductService {

    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Set<Product> getProduct();
    public Product getProduct(Long id);
    public void deleteProduct(long id);



}
