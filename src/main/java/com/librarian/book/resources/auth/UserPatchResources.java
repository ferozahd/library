package com.librarian.book.resources.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserPatchResources {
    @NotNull
    @Size(min = 2,max = 20,message = " student name 2 er coto abg 20 er boro hobe na")
    private  String studentName;
    @NotNull
    @Email(message = "email not valid")
    private String email;
    @NotNull
    @Size(min = 6,max = 8,message = "password 6 er coto abg 8 er boro hobe na")
    private String password;
}
