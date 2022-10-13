package com.demo.ecommerce.service;

import com.demo.ecommerce.model.Author;

public interface AuthorService {
    //For Creating User
    public Author createUser(Author author) throws Exception;
    //get User
    public Author getUser(String username);
}
