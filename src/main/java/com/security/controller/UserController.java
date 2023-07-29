package com.security.controller;

import com.security.model.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private JdbcUserDetailsManager userDetailsManager;
    @Autowired
    BCryptPasswordEncoder encoder;
    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest request) {
        // Perform additional validation and processing as needed.
        userDetailsManager.createUser(User
                .withUsername(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .roles(request.getAuthorities()) // Assign any necessary roles here
                .build());

        return "User registered successfully!";
    }
    @GetMapping("/home")
    public  String  home(){
        return "HomePage";
    }
    @GetMapping("/profile")
    public  String  profile(){
        return "Welcome To Profile Page";
    }
}

