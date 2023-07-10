//package com.spring.employee.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.spring.employee.entity.User;
//import com.spring.employee.repository.UserRepository;
//
//@Controller
//@RequestMapping("/auth")
//public class AuthController 
//{
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//    private AuthenticationManager authenticationManager;
//	
//	
//
//    @PostMapping("/login")
//    public String login(@RequestBody User loginRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthentication(loginRequest.getUsername(), loginRequest.getPassword()));
//            User user = userRepository.findByUsername(loginRequest.getUsername());
//            userRepository.save(user); 
//            return "Login successful!";
//        } catch (AuthenticationException e) {
//            
//            return "Login failed!";
//        }
//    }
//    
//    @PostMapping("/signup")
//    public String signup(@RequestBody User signupRequest) {
//        if (userRepository.existsByUsername(signupRequest.getUsername())) {
//            return "Username already exists!";
//        }
//
//        // Create a new user entity
//        User newUser = new User();
//        newUser.setUsername(signupRequest.getUsername());
//        newUser.setPassword(signupRequest.getPassword());
//
//        // Save the new user in the repository
//        userRepository.save(newUser);
//
//        return "Signup successful!";
//    }
//
//}
