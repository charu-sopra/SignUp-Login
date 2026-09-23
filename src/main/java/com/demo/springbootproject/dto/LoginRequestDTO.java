package com.demo.springbootproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class LoginRequestDTO {
    private String email;
    private String password;
}
