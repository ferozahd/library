package com.librarian.book.controller.impl;

import com.librarian.book.controller.AuthenticationController;
import com.librarian.book.entity.Review;
import com.librarian.book.entity.auth.User;
import com.librarian.book.enums.ReviewEnum;
import com.librarian.book.repository.UserRepository;
import com.librarian.book.resources.auth.AuthResponse;
import com.librarian.book.resources.auth.LoginPostResources;
import com.librarian.book.resources.auth.UserRegisterGetResources;
import com.librarian.book.resources.auth.UserRegisterPostResources;
import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.librarian.book.enums.ReviewEnum.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {
    private final AuthService authService;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<AuthResponse> login(LoginPostResources loginpostResources) {
        return ResponseEntity.ok(authService.login(loginpostResources)) ;
    }


    @Override
    public ResponseEntity<UserRegisterGetResources> register(UserRegisterPostResources registerPostResources) {
        User user = new User();
        user.setStudentName(registerPostResources.getStudentName());
        user.setEmail(registerPostResources.getEmail());
        user.setPassword(registerPostResources.getPassword());
        userRepository.save(user);

        UserRegisterGetResources resources=new UserRegisterGetResources();
        resources.setId(user.getId().toHexString());
        resources.setStudentName(user.getStudentName());
        resources.setEmail(user.getEmail());
        return ResponseEntity.ok(resources);
    }

    @Override
    public ResponseEntity<List<UserRegisterGetResources>> getAll() {

        List<User> registers = userRepository.findAll();
        List<UserRegisterGetResources> response = new ArrayList<>();
       registers.forEach(register-> {
            UserRegisterGetResources resources = new UserRegisterGetResources();
            resources.setId(register.getId().toHexString());
            resources.setStudentName(register.getStudentName());
          resources.setEmail(register.getEmail());

            response.add(resources);
        });
        return ResponseEntity.ok(response);
    }


    }

