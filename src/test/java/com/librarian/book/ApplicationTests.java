package com.librarian.book;

import com.librarian.book.entity.Review;
import com.librarian.book.entity.auth.User;
import com.librarian.book.enums.LevelEnum;
import com.librarian.book.repository.ReviewRepository;
import com.librarian.book.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootTest
class ApplicationTests {

    @Resource
    ReviewRepository reviewRepository;
    @Resource
    UserRepository userRepository;

    @Test
    void contextLoads() {
        List<User> users = List.of(new User(null, "Nasir Uddin", "12345", "nasir@example.com"),
                new User(null, "Afsar Ali", "982348", "afsar@example.com"),
                new User(null, "Helal Uddin", "jsdhx3", "helal@example.com"),
                new User(null, "Mr Hassan", "1j3l49", "mr_hasan@example.com"),
                new User(null, "Sultana Khatun", "sdf323", "sultana@example.com"),
                new User(null, "Feroz Ahmmed", "54*&9sdf", "feroz@example.com"));

        List<Review> reviews = List.of(new Review(null, null, "Awesome review from ", LevelEnum.FIVESTAER),
                new Review(null, null, "I am happy review from ", LevelEnum.FOURSTAER),
                new Review(null, null, "I am feeling good review from ", LevelEnum.THEREESTAER),
                new Review(null, null, "I am not feeling well review from ", LevelEnum.TWOSTAER),
                new Review(null, null, "I am angry review from ", LevelEnum.ONESTAER)
        );
        List<Review> reviewToSave = userRepository.saveAll(users)
                .stream()
                .flatMap(user -> reviews.stream().map(review -> {
                           return new Review(review.getId(),user.getId().toHexString(),review.getReviewText()+user.getStudentName(), review.getLevel());
                        })
                )
                .collect(Collectors.toList());



        reviewRepository.saveAll(reviewToSave);
    }

}
