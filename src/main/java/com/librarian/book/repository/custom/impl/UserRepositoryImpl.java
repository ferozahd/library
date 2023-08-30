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

    @Override
    public Optional<User> findByEmail(String email) {
            Query query = new Query(Criteria.where("email").is(email));
            User user = mongoTemplate.findOne(query, User.class);
            return Optional.ofNullable(user);
        }



    @Override
    public Optional<User> findByStudentName(String name) {
        Query query = new Query(Criteria.where("studentName").is(name));
        User user = mongoTemplate.findOne(query, User.class);
        return Optional.ofNullable(user);
    }
}
