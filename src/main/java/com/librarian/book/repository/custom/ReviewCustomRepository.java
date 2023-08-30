package com.librarian.book.repository.custom;

import com.librarian.book.entity.Review;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface ReviewCustomRepository {
    List<Review> findByStudentId(String studentId);

    void deleteByStudentId(String studentId);
}
