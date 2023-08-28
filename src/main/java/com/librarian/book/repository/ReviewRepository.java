package com.librarian.book.repository;

import com.librarian.book.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    void deleteByStudentId(String id);

    List<Review> findByStudentId(String id);
}
