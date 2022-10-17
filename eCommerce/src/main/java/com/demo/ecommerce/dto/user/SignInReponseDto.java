package com.demo.ecommerce.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignInReponseDto {

    private String status;
    private String token;

    public SignInReponseDto(String status, String token) {
        this.status = status;
        this.token = token;
    }
}
