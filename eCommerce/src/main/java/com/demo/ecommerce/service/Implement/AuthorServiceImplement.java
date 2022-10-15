package com.demo.ecommerce.service.Implement;

import com.demo.ecommerce.model.Author;
import com.demo.ecommerce.repository.AuthorRepo;
import com.demo.ecommerce.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorServiceImplement implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;


    @Override
    public Author createUser(Author author) throws Exception {
        Author local = this.authorRepo.findByUsername(author.getUsername());
        if (local != null) {
            throw new Exception("User already present");
        } else {
            local = this.authorRepo.save(author);
            return local;
        }
    }

    @Override
    public Author getUser(String username) {
        return this.authorRepo.findByUsername(username);
    }

//    //SecurityConfig
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Author author = authorRepo.findByUsername(username);
//        return new org.springframework.security.core.userdetails.User(author.getUsername(),author.getPassword(),new ArrayList<>());
//    }
}

