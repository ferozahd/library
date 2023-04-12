package com.librarian.book.controller;

import com.librarian.book.entity.auth.User;
import com.librarian.book.resources.auth.AuthResponse;
import com.librarian.book.resources.auth.LoginPostResources;
import com.librarian.book.resources.auth.UserRegisterGetResources;
import com.librarian.book.resources.auth.UserRegisterPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticationController {


    @PostMapping("/register")
    ResponseEntity<UserRegisterGetResources> register(@RequestBody UserRegisterPostResources registerPostResources);


    @PostMapping("/login")
    ResponseEntity<AuthResponse> login(@RequestBody LoginPostResources postResources);

}
