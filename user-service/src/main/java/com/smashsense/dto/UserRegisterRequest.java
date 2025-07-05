package com.smashsense.dto;

import lombok.Data;

//This is the DTO of the Spring boot application, which is the Data Transfer Object 

// DTO -> This is used to carry the data between the client(Frontend) and backend.

@Data
public class UserRegisterRequest { // This class is used as a request body when the client sends data to the server
                                   // — specifically during user registration.
    private String username;
    private String fullName;
    private String email;
    private String password;

}
