package com.demo.ecommerce.controller;


import com.demo.ecommerce.dto.ResponseDto;
import com.demo.ecommerce.dto.user.SignInDto;
import com.demo.ecommerce.dto.user.SignInReponseDto;
import com.demo.ecommerce.dto.user.SignupDto;
import com.demo.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userServices;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userServices.signUp(signupDto);
    }


    @PostMapping("/signin")
    public SignInReponseDto signIn(@RequestBody SignInDto signInDto) {
        return userServices.signIn(signInDto);
    }

}

