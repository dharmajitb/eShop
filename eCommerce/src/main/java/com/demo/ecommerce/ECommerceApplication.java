package com.demo.ecommerce;


import com.demo.ecommerce.model.Role;
import com.demo.ecommerce.model.User;
import com.demo.ecommerce.model.UserRole;
import com.demo.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;



    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting Code");
//
//        User user = new User();
//        user.setFirstName("Customer");
//        user.setLastName("DB");
//        user.setUsername("Customer");
//        user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
//        user.setEmail("email@gmail.com");
//        user.setPhone("986011247");
//
//        Role role = new Role();
//        role.setRoleId(2L);
//
//        Set<UserRole> userRoleSet = new HashSet<>();
//        UserRole userRole = new UserRole();
//
//        userRole.setRole(role);
//        userRoleSet.add(userRole);
//
//        User user1 = this.userService.createUser(user,userRoleSet);
//        System.out.println(user1.getUsername());
    }
}
