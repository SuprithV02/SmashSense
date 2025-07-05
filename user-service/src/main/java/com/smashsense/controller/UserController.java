package com.smashsense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smashsense.dto.UserRegisterRequest;
import com.smashsense.model.User;
import com.smashsense.service.UserService;

@RestController // This class will handle REST API calls.This is a combination of @Controller -
                // for marking the class as a web controller and @ResponseBody - to
                // automatically convert the return values to JSON
@RequestMapping("/users") // All endpoints in this class will start with /users
public class UserController {

    @Autowired // Spring will automatically inject the UserService bean here
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRegisterRequest request) { // RequestBody converts the request body into a
                                                                         // java object, Spring uses Jackson(JSON parser
                                                                         // library) under the hood
        return userService.registerUser(request);
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

}
