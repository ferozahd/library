package com.librarian.book.repository;

import com.librarian.book.entity.auth.User;
import com.librarian.book.repository.custom.UserCustomRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>, UserCustomRepository {

}
