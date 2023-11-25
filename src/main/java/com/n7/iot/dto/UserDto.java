package com.n7.iot.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String role;
}
