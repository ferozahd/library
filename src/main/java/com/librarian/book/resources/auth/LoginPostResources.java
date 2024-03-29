package com.librarian.book.resources.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginPostResources {
    @NotNull(message = "Email must have to provide")
    @Email(message = "Must have to be an valid email")
    private String email;
    @NotNull
    @Size(min = 6, max = 8, message = "Password must be between 6 to 8 character")
    private String password;
}
