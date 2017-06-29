package com.codecool.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

@Getter @Setter
public class StudentDto {

    @Email
    private String email;
    @Size(min = 8)
    private String password;
}
