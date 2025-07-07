package com.smashsense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.smashsense.dto.JwtResponse;
import com.smashsense.dto.LoginRequest;
import com.smashsense.model.User;
import com.smashsense.service.UserService;
import com.smashsense.util.JwtUtil;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        User user;
        try {
            user = userService.findByUsername(request.getUsername());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid credentials");
        }

        if (!userService.checkPassword(request.getPassword(), user.getPassword())) {
            System.out.println("Invalid password");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new JwtResponse(token);
    }

}
