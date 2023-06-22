package com.spring.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.employee.entity.User;

@Controller
public class AuthController 
{
	@Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            
            // Authentication successful
            // Generate and return an authentication token or perform any other required action
            
            return "Login successful!";
        } catch (AuthenticationException e) {
            // Authentication failed
            // Handle unsuccessful login (e.g., return error message, redirect to login page)
            
            return "Login failed!";
        }
    }

}
