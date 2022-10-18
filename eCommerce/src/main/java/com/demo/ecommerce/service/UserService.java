package com.demo.ecommerce.service;

import com.demo.ecommerce.model.User;
import com.demo.ecommerce.model.UserRole;
import com.demo.ecommerce.repository.RoleRepository;
import com.demo.ecommerce.repository.UserRepository;
import com.demo.ecommerce.service.Implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserService implements UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            System.out.println("User is Already there !! ");
            throw new Exception("User already present !!");
        }else {
            //User Create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRole().addAll(userRoles);
            local = this.userRepository.save(user);
            return local;
        }
    }

    //getting user ----get User
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    //Delete User By ID
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
    //update
    @Override
    public void updateUser(User user, long userId) {
    }
}
