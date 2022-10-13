package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
    Author findByUsername(String username);

}
