package com.librarian.book.repository;

import com.librarian.book.entity.AssignBook;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignRepository extends MongoRepository<AssignBook, ObjectId> {
}
