package com.librarian.book.controller.impl;

import com.librarian.book.controller.ReviewController;
import com.librarian.book.repository.UserRepository;
import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.resources.review.ReviewPostResources;


import com.librarian.book.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class ReviewControllerImpl implements ReviewController {
    private final ReviewService reviewService;



    public ReviewControllerImpl(ReviewService reviewService, UserRepository userRepository){
        this.reviewService=reviewService;

    }
    @Override
    public ResponseEntity<ReviewGetResources> create(ReviewPostResources reviewPostResources) {
        return ResponseEntity.ok(reviewService.create(reviewPostResources));
    }

    @Override
    public ResponseEntity<List<ReviewGetResources>> getAll() {
        return ResponseEntity.ok(reviewService.getAll());
    }

    @Override
    public ResponseEntity<ReviewGetResources> findById(String reviewId) {
        return null;
    }

    @Override
    public ResponseEntity<List<ReviewGetResources>> getReviewDetailsByUserId(String id) {
        return ResponseEntity.ok(reviewService.getReviewDetailsByUserId(id));
    }


}
