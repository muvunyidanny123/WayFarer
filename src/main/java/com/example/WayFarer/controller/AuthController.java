package com.example.WayFarer.controller;

import lombok.Data;
import com.example.WayFarer.entity.User;
import com.example.WayFarer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Nkurikiyimana Aimable, Iradukunda Joselyne, Mariza Jeanne
 * RegNo: 24582/2024, 21438/2024, 21504/2023
 */

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public Response signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userService.saveUser(user);
        return new Response(201, savedUser);
    }

    @PostMapping("/signin")
    public Response signin(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new Response(200, user);
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
@Data
    static class Response {
        private int status;
        private Object data;

        public Response(int status, Object data) {
            this.status = status;
            this.data = data;
        }

        // getters and setters
    }
    @Data
    static class LoginRequest {
        private String email;
        private String password;

        // getters and setters
    }
}
