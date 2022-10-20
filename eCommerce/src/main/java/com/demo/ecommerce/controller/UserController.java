package com.demo.ecommerce.controller;


import com.demo.ecommerce.model.Role;
import com.demo.ecommerce.model.User;
import com.demo.ecommerce.model.UserRole;
import com.demo.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Create User
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();

        //Encoding password bCryptPasswordEncoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));


        Role role = new Role();
        role.setRoleId(2L);
        role.setRoleName("Customer");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user,roles);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return  this.userService.getUser(username);
    }

    //    delete the user
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") long userId){
        this.userService.deleteUser(userId);
    }
    //Update user --->>>>> put method
    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable("userId") long userId){
        this.userService.updateUser(user, userId);
        return user;
    }

}

//    @PostMapping("/signup")
//    public ResponseDto signup(@RequestBody SignupDto signupDto) {
//        return userServices.signUp(signupDto);
//    }
//
//
//    @PostMapping("/signin")
//    public SignInReponseDto signIn(@RequestBody SignInDto signInDto) {
//        return userServices.signIn(signInDto);
//    }
//
//}

