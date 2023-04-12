package com.librarian.book.resources.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPostResources {
    private String email;
    private String password;
}
