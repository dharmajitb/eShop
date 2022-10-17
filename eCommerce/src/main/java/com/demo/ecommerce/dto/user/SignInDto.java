package com.demo.ecommerce.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignInDto {
    private String email;
    private String password;


    public SignInDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
