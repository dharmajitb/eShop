package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.AuthenticationToken;
import com.demo.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken,Integer> {
    public AuthenticationToken findByUser(User user);
    public AuthenticationToken findByToken(String token);
}
