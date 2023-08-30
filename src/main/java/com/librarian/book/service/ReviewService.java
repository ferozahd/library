package com.librarian.book.service;

import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.resources.review.ReviewPostResources;

import java.util.List;

public interface ReviewService {
    ReviewGetResources create(ReviewPostResources reviewPostResources);

    List<ReviewGetResources> getAll();


   List<ReviewGetResources> getReviewDetailsByCurrentUser();
}
