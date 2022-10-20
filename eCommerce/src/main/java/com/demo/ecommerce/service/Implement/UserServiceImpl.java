package com.demo.ecommerce.service.Implement;

import com.demo.ecommerce.model.User;
import com.demo.ecommerce.model.UserRole;

import java.util.HashMap;
import java.util.Set;

public interface UserServiceImpl {
    User signUpUser(HashMap<String,String> signupRequest);
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    //get User
    public User getUser(String username);

    //delete user by ID
    public void deleteUser(Long userId);

    public void updateUser(User user, long userId);



}

