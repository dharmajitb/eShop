package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.Author;
import com.demo.ecommerce.service.AuthorService;
import com.demo.ecommerce.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/")
    public ResponseEntity<Author> addProduct(@RequestBody Author author) throws Exception {
        Author author1 = this.authorService.createUser(author);
        return ResponseEntity.ok(author1);
    }

    @GetMapping("/user/{username}")
    public Author getUser(@PathVariable("username") String username){
        return this.authorService.getUser(username);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody Author author) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(author.getUsername(),author.getPassword()));
        }catch (Exception ex){
            throw new Exception("Invalid username or password");
        }
        return jwtUtil.generateToken(author.getUsername());

    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Dashboard !!";
    }
}
