package com.librarian.book.mapper;


import com.librarian.book.entity.Review;
import com.librarian.book.entity.auth.User;
import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.resources.review.ReviewPostResources;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review toReviewWithStudent( ReviewPostResources reviewPostResources){
       Review review = new Review();
//       review.setStudentId(student.getId().toHexString());
       review.setLevel(reviewPostResources.getLevel());
       review.setReviewText(reviewPostResources.getReviewText());
       return review;
   }


    public ReviewGetResources toReviewGetResource(User student, Review review){
        ReviewGetResources response = new ReviewGetResources();
        response.setId(review.getId().toHexString());
        response.setStudentId(student.getId().toHexString());
        response.setStudentName(student.getStudentName());
        response.setEmail(student.getEmail());
        response.setReviewText(review.getReviewText());
        response.setLevel(review.getLevel());
        return response;
    }



}
