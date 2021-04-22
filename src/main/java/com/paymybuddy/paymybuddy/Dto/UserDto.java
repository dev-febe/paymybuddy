package com.paymybuddy.paymybuddy.Dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
