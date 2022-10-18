package com.demo.ecommerce;


import com.demo.ecommerce.model.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);

//        Role role = new Role();
//        role.setRoleId(3L);
//        role.setRoleName("Customer");
        
    }

}
