package com.demo.ecommerce.service;

import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ProductService {

    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Set<Product> getProduct();
    public Product getProduct(Long id);
    public void deleteProduct(long id);

//    @Autowired
//    private ProductRepository productRepository;

//    //add
//    public void addProduct(Product product){
//        productRepository.save(product);
//    }
//    //delete
//    public void deleteProduct (long id){
//        productRepository.deleteById(id);
//    }
//
//    //get
//    public Product getProductById(long id){
//        return productRepository.getOne(id);
//    }
//
//    public List<Product> getAllProduct(){
//        return productRepository.findAll();
//    }
//

}
