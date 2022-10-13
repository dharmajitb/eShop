package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.Author;
import com.demo.ecommerce.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/")
    public ResponseEntity<Author> addProduct(@RequestBody Author author) throws Exception {
        Author author1 = this.authorService.createUser(author);
        return ResponseEntity.ok(author1);
    }

    @GetMapping("/user/{username}")
    public Author getUser(@PathVariable("username") String username){
        return this.authorService.getUser(username);
    }


    @GetMapping("/")
    public String welcome() {
        return "Welcome to Dashboard !!";
    }
}
