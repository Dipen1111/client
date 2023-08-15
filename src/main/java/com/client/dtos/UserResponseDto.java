package com.client.dtos;

import lombok.Data;

@Data
public class  UserResponseDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String role;
    private String email;
    private String password;
}
