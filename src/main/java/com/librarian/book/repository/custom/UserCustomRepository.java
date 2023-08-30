package com.librarian.book.repository.custom;

import com.librarian.book.entity.auth.User;

import java.util.Optional;

public interface UserCustomRepository {
    Optional<User> findByEmail(String email);

    Optional<User> findByStudentName(String name);
}
