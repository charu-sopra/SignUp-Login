package com.demo.springbootproject.service;
import com.demo.springbootproject.Entity.UserEntity;
import com.demo.springbootproject.dto.SignUpRequestDTO;
import com.demo.springbootproject.dto.SignUpResponseDTO;
import com.demo.springbootproject.repository.UserRepository;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository; //service to repository

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SignUpResponseDTO saveUser(SignUpRequestDTO signUpRequestDTO) {
        UserEntity user = new UserEntity();

        if(!signUpRequestDTO.getConfirmPassword().equals(signUpRequestDTO.getPassword())){
            throw new IllegalArgumentException("Passwords do not match");        }

        String encodedPassword = passwordEncoder.encode(signUpRequestDTO.getPassword());

        user.setEmployeeId(signUpRequestDTO.getEmployeeId());
        user.setFirstName(signUpRequestDTO.getFirstName());
        user.setLastName(signUpRequestDTO.getLastName());
        user.setMiddleName(signUpRequestDTO.getMiddleName());
        user.setPhoneNo(signUpRequestDTO.getPhoneNo());
        user.setDesignation(signUpRequestDTO.getDesignation());
        user.setUserRole(signUpRequestDTO.getUserRole());
        user.setEmail(signUpRequestDTO.getEmail());
        user.setPassword(encodedPassword);        
        user.setCreatedAt(LocalDateTime.now());

        

        UserEntity savedUser = userRepository.save(user);

        return new SignUpResponseDTO(
        savedUser.getId(),
        savedUser.getEmployeeId(),
        savedUser.getFirstName(),
        savedUser.getMiddleName(),
        savedUser.getLastName(),
        savedUser.getPhoneNo(),
        savedUser.getEmail(),
        savedUser.getDesignation(),
        savedUser.getUserRole(),
        savedUser.getCreatedAt()
);
    }
}