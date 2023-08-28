package com.librarian.book.controller;

import com.librarian.book.resources.auth.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("auth")
public interface AuthenticationController {

    @PostMapping("/user/register")
    ResponseEntity<UserGetResources> register(@RequestBody @Valid UserRegisterPostResources registerPostResources);

    @PatchMapping("user/update/{id}")
    ResponseEntity<UserGetResources> updateUser(@PathVariable String id, @RequestBody @Valid UserPatchResources patchResources );

    @DeleteMapping("user/delete/{id}")
    ResponseEntity<?> deleteUser(@PathVariable String id);

    @GetMapping("/register/get-all")
    ResponseEntity<List<UserGetResources>> getAll();


    @PostMapping("/login")
    ResponseEntity<AuthGetResource> login(@Valid @RequestBody LoginPostResources post);

}
