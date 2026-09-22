package com.demo.springbootproject.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class SignUpResponseDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public SignUpResponseDTO(Long id, String name, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt  = createdAt;
    }

}