package com.librarian.book.resources.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterPostResources {
    private  String studentName;
    private  String password;
    private String email;
}
