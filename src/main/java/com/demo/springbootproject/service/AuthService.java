package com.demo.springbootproject.service;

import com.demo.springbootproject.dto.LoginResponseDTO;
import com.demo.springbootproject.User;
import com.demo.springbootproject.repository.UserRepository;
import com.demo.springbootproject.security.JwtService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            JwtService jwtService,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(String email, String password) {

        // 1. Find user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));


        // 2. Check password
        if (!passwordEncoder.matches(
                password,
                user.getPassword())) {

            throw new RuntimeException("Invalid email or password");
        }

        // 3. Generate JWT
        String token = jwtService.generateTokens(user);

        // 4. Return login response
         return new LoginResponseDTO(
                "Login successful",
                token
        );
    }
}