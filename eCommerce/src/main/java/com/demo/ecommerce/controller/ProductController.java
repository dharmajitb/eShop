package com.demo.ecommerce.controller;
import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.ProductRepository;
import com.demo.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //add products
    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product1 = this.productService.addProduct(product);
        return ResponseEntity.ok(product1);
    }

    //get  Products by ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return this.productService.getProduct(id);
    }

    //    Get all Product
    @GetMapping("/")
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(this.productService.getProduct());
    }

    //Update
    @PutMapping("/")
    public Product updateProduct(@RequestBody Product product){
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id")long id){
        this.productService.deleteProduct(id);
    }

}