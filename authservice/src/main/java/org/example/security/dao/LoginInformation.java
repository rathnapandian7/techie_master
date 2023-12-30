package org.example.security.dao;

import lombok.Data;

@Data
public class LoginInformation {

    private String token;

    private String refreshToken;
}