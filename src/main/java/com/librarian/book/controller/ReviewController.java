package com.librarian.book.controller;

import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.resources.review.ReviewPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("review")
public interface ReviewController {
    @PostMapping("/create")
    ResponseEntity<ReviewGetResources> create(@RequestBody @Valid ReviewPostResources reviewPostResources);

    @GetMapping("/get-All")
    ResponseEntity<List<ReviewGetResources>> getAll();

    @GetMapping("/{reviewId}")
    ResponseEntity<ReviewGetResources> findById(@PathVariable String reviewId);

    @GetMapping("/current-user")
    ResponseEntity<List<ReviewGetResources>> getReviewDetailsByCurrentUser();




}
