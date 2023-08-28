package com.librarian.book.controller;


import com.librarian.book.resources.auth.AuthGetResource;
import com.librarian.book.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class TestController {
    private final JwtTokenService jwtTokenService;

//    @PostMapping("/token-extract")
//    ResponseEntity<Map<String, Object>> getTokenValue(@RequestBody AuthGetResource auth){
//       return ResponseEntity.ok(jwtTokenService.getClaim(auth.getToken()));
//    }
}
