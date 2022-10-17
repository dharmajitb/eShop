package com.demo.ecommerce.service;


import com.demo.ecommerce.dto.ResponseDto;
import com.demo.ecommerce.dto.user.SignInDto;
import com.demo.ecommerce.dto.user.SignInReponseDto;
import com.demo.ecommerce.dto.user.SignupDto;
import com.demo.ecommerce.exception.AuthenticationFailException;
import com.demo.ecommerce.exception.CustomException;
import com.demo.ecommerce.model.AuthenticationToken;
import com.demo.ecommerce.model.User;
import com.demo.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Transactional
    public ResponseDto signUp(SignupDto signupDto) {
        //check user already or not
        if(Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))){
            throw new CustomException("User already Created");
        }
        //encrypt password
        String encryptedPassword = signupDto.getPassword();
        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //save user
        User user = new User(signupDto.getFirstName(),signupDto.getLastName(),signupDto.getEmail(),encryptedPassword);
        User save = userRepository.save(user);

        //Generate Authorization token
        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        //Save the token by calling authenticationService
        authenticationService.saveConfirmationToken(authenticationToken);
        //encrypt password
        ResponseDto responseDto = new ResponseDto("success","Create new user");

        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInReponseDto signIn(SignInDto signInDto) {
        // find user email
        User user = userRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
            throw new AuthenticationFailException("user is not valid");
        }

        try {
            // compare the password in DB

            // check password match
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }



        // retrive the token
        AuthenticationToken token = authenticationService.getToken(user);


        // return response

        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }

        return new SignInReponseDto("sucess", token.getToken());


    }
}
