package com.librarian.book.repository;

import com.librarian.book.entity.Review;
import com.librarian.book.entity.auth.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}
