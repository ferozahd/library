package com.librarian.book.controller;

import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.resources.review.ReviewPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;

@RequestMapping("/review")
public interface HomeController {
    @PostMapping("/create")
    ResponseEntity<ReviewGetResources> create(@RequestBody ReviewPostResources reviewPostResources);

    @GetMapping("/get-All")
    ResponseEntity<List<ReviewGetResources>> getAll();


    @PostMapping("/jwt-generate")
    ResponseEntity<?> generateJwt(@RequestBody Map<String, Object> values) throws InvalidKeySpecException, NoSuchAlgorithmException;

}
