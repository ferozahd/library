package com.librarian.book.controller.impl;

import com.librarian.book.controller.HomeController;
import com.librarian.book.entity.Review;
import com.librarian.book.enums.ReviewEnum;
import com.librarian.book.repository.AssignRepository;
import com.librarian.book.repository.ReviewRepository;
import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.resources.review.ReviewPostResources;


import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static com.librarian.book.enums.ReviewEnum.*;

@RestController
@RequiredArgsConstructor
public class HomeControllerImpl implements HomeController {
    private final ReviewRepository reviewRepository;
    private final AssignRepository assignRepository;
    @Override
    public ResponseEntity<ReviewGetResources> create(ReviewPostResources reviewPostResources) {

        Review review = new Review();
        review.setStudentName(reviewPostResources.getStudentName());
        review.setRoll(reviewPostResources.getRoll());
        review.setReview(reviewPostResources.getReview());
        review.setBookName(reviewPostResources.getBookName());
        reviewRepository.save(review);

        ReviewGetResources resources = new ReviewGetResources();
        resources.setId(review.getId().toHexString());
        resources.setStudentName(review.getStudentName());
        resources.setRoll(review.getRoll());
        if (review.getReview().equals(POOR)) {
            resources.setReview("1*");
        } else if (review.getReview().equals(GOOD)) {
            resources.setReview("2*");
        } else if (review.getReview().equals(AVERAGE)) {
            resources.setReview("3*");
        }else if (review.getReview().equals(BEST)) {
            resources.setReview("4*");
        }else if (review.getReview().equals(AWESOME)) {
            resources.setReview("5*");
        }
        resources.setBookName(review.getBookName());
        return ResponseEntity.ok(resources);
    }

    @Override
    public ResponseEntity<List<ReviewGetResources>> getAll() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewGetResources> response = new ArrayList<>();
        reviews.forEach(review -> {
            ReviewGetResources resources = new ReviewGetResources();
            resources.setId(review.getId().toHexString());
            resources.setStudentName(review.getStudentName());
            resources.setRoll(review.getRoll());
            if (review.getReview()!=null && review.getReview().equals(ReviewEnum.POOR)) {
                resources.setReview("1*");
            }
            if (review.getReview()!=null && review.getReview().equals(ReviewEnum.GOOD)) {
                resources.setReview("2*");
            }
            if (review.getReview()!=null && review.getReview().equals(AVERAGE)) {
                resources.setReview("3*");
            }
            if (review.getReview()!=null && review.getReview().equals(BEST)) {
                resources.setReview("4*");
            }
            if (review.getReview()!=null && review.getReview().equals(AWESOME)) {
                resources.setReview("5*");
            }
            resources.setBookName(review.getBookName());
            response.add(resources);
        });
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> generateJwt(Map<String, Object> values)  {

        return ResponseEntity.ok(Jwts.builder()
                .setSubject("Feroz")
                .setClaims(values)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000))
                .signWith(SignatureAlgorithm.HS512, "YW1lcnNvbmFuhijmmlugbuhnuhwerhwefsndfjdfbgifandidshgbweidknaklfbndsjabqiwfjnesofwandjerbgioewjfsdoknijyYmFuZ2xh")
                .compact());

    }


}
