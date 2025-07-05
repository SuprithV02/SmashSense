package com.smashsense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smashsense.dto.UserRegisterRequest;
import com.smashsense.model.User;
import com.smashsense.repository.UserRepository;

//This is the service layer of our spring boot application

@Service  //Tells Spring Boot: "This class does important logic stuff — manage it for me."
public class UserService {

    @Autowired //Spring automatically injects an instance of UserRepository here.So you can use it to save users to the database without writing SQL.
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(UserRegisterRequest request) {
        User user = User.builder().username(request.getUsername()).fullName(request.getFullName()) //builder creates a new User Object
                .username(request.getFullName()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())).build();

        return userRepository.save(user);
    }

}
