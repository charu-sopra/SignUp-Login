package com.demo.springbootproject.service;
import com.demo.springbootproject.User;
import com.demo.springbootproject.dto.SignUpRequestDTO;
import com.demo.springbootproject.dto.SignUpResponseDTO;
import com.demo.springbootproject.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository; //service to repository

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignUpResponseDTO saveUser(SignUpRequestDTO signUpRequestDTO) {
        User user = new User();

        user.setName(signUpRequestDTO.getName());
        user.setEmail(signUpRequestDTO.getEmail());
        user.setPassword(signUpRequestDTO.getPassword());

        

        User savedUser = userRepository.save(user);

        return new SignUpResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }
}