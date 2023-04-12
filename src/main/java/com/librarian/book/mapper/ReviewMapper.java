//package com.librarian.book.mapper;
//
//import com.librarian.book.entity.Review;
//import com.librarian.book.resources.review.ReviewGetResources;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.processing.Generated;
//
//@Generated(
//        value = "org.mapstruct.ap.MappingProcessor",
//        date = "2023-02-23T01:35:40+0600",
//        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
//)
//@Component
//public class ReviewMapperImpl implements  ReviewMapper{
//
//
//    @Override
//    public ReviewGetResources toResources(Review review) {
//        ReviewGetResources resources=new ReviewGetResources();
//        resources.setId(review.getId().toHexString());
//        resources.setStudentName(review.getStudentName());
//        resources.setRoll(review.getRoll());
//        resources.setReview(review.getReview());
//        return resources;
//    }
//
//
//}
