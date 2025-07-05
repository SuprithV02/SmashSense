package com.smashsense.dto;

import lombok.Data;

@Data // This annotation is from Lombok...where it will have the predefined setters and getters
public class LoginRequest {
    private String username;
    private String password;
}
