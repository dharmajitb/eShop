package com.demo.ecommerce.service.Implement;

import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.ProductRepository;
import com.demo.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return this.productRepository.save(product);
    }
    // get all product
    @Override
    public Set<Product> getProduct() {
        return new HashSet<>(this.productRepository.findAll());
    }
    //get  a product
    @Override
    public Product getProduct(Long id) {
        return this.productRepository.findById(id).get();
    }
    //Delete Product by ID
    @Override
    public void deleteProduct(long id) {
        Product product = new Product();
        product.setId(id);
        this.productRepository.delete(product);

    }
}
