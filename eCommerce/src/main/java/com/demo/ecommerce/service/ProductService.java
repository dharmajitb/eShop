package com.demo.ecommerce.service;

import com.demo.ecommerce.dto.ProductDto;
import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.ProductRepository;
import com.demo.ecommerce.service.Implement.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    ProductRepository productRepository;

    //Create Product
    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        productRepository.save(product);
    }

    //get Product
    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getCid());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getPid());
        return productDto;
    }
    //get all product
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product: allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, long productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }
        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }
    // Delete

    public void deleteProduct(long pid){
        Product product = new Product();
        product.setPid(pid);
        this.productRepository.delete(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return this.productRepository.save(product);
    }
}
