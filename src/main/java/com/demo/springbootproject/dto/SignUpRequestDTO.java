package com.demo.springbootproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class SignUpRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email
    @NotBlank(message="Sopra Steria email is required ")
    @Pattern
    (regexp = "^[A-Za-z0-9._%+-]+@soprasteria\\.com$",
    message = "Please use your company email address")
    private String email;
    

    @NotBlank
    @Size(min = 12, message = "Password must be at least 12 characters")
    private String password;

}
