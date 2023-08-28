package com.librarian.book.controller.impl;


import com.librarian.book.controller.AuthenticationController;

import com.librarian.book.resources.auth.*;
import com.librarian.book.service.AuthService;
import com.librarian.book.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthenticationControllerImpl implements AuthenticationController {
    private final AuthService authService;
    private final CommonService commonService;

    @Override
    public ResponseEntity<AuthGetResource> login(LoginPostResources post) {
        log.info("Name"+commonService.getName());
        log.info("Email"+commonService.getEmail());
        log.info("id"+ commonService.getId());
     return ResponseEntity.ok(authService.login(post));
    }

    @Override
    public ResponseEntity<UserGetResources> register(UserRegisterPostResources registerPostResources) {
      return ResponseEntity.ok(authService.register(registerPostResources));
    }

    @Override
    public ResponseEntity<UserGetResources> updateUser(String id, UserPatchResources patchResources) {
        return ResponseEntity.ok( authService.updateUser(patchResources,id));
    }

    @Override
    public ResponseEntity<?> deleteUser(String id) {
        authService.deleteUser(id);
        return null;
    }


    @Override
    public ResponseEntity<List<UserGetResources>> getAll() {
        return ResponseEntity.ok(authService.getAllUser());
    }


}

