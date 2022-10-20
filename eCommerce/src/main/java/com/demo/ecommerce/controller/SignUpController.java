package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.User;
import com.demo.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<?> userLogin(@RequestBody HashMap<String, String> signupRequest) {
        //TODO validation has to add for client request
        User user = userService.signUpUser(signupRequest);
        return ResponseEntity.ok(user);

    }

}
