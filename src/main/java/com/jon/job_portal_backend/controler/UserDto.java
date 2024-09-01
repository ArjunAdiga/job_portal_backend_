package com.jon.job_portal_backend.controler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String email;
    private String password;
    private String name;
    private String role;
}


