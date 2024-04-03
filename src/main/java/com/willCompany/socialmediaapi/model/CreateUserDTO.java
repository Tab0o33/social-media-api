package com.willCompany.socialmediaapi.model;

import lombok.Data;

@Data
public class CreateUserDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String profilImage;
}
