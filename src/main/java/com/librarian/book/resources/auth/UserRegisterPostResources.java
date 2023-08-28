package com.librarian.book.resources.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRegisterPostResources {
    @NotNull(message = "Studnet name should not be null")
    @Size(min = 2, max = 20 , message = "2 characters hote 20 character er moddhei hote hobe")
    private  String studentName;

    @NotNull(message = "Studnet passworld should not be null")
    @Size(min = 6, max = 8 ,message = "password obossoy 6 to 8 character er moddhei hote hobe")
    private  String password;
    @Email(message = "Email obossoy valid hote hobe")
    @NotNull(message =  "Email must not be null")
    private String email;
}
