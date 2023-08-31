package com.librarian.book.repository.custom.impl;

import com.librarian.book.entity.auth.User;
import com.librarian.book.repository.custom.UserCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserCustomRepository {
    private final MongoTemplate mongoTemplate;
//test comment2
    @Override
    public Optional<User> findByEmail(String email) {
        final Query query = new Query(Criteria.where("email").is(email));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }


    @Override
    public Optional<User> findByStudentName(String name) {
        final Query query = new Query(Criteria.where("studentName").is(name));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }
}
