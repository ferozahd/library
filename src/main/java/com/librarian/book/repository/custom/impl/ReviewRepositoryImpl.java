package com.librarian.book.repository.custom.impl;

import com.librarian.book.entity.Review;
import com.librarian.book.repository.custom.ReviewCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewCustomRepository {
    private final MongoTemplate mongoTemplate;




    @Override
    public void deleteByStudentId(String studentId) {
        mongoTemplate.remove(
                Query.query(Criteria.where("studentId").is(studentId))
                ,Review.class);

    }


    @Override
    public List<Review> findByStudentId(String studentId) {
       return mongoTemplate.find(
                Query.query(Criteria.where("studentId").is(studentId))
                ,Review.class);
    }


}
