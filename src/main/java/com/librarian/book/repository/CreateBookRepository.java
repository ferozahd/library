package com.librarian.book.repository;

import com.librarian.book.entity.CreateBook;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateBookRepository extends MongoRepository <CreateBook, ObjectId> {
}
