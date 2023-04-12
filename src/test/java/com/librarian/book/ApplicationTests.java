package com.librarian.book;

import com.librarian.book.entity.Review;
import com.librarian.book.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApplicationTests {

	@Resource
	ReviewRepository reviewRepository;
	@Test
	void contextLoads() {
		Review review =new Review();
		review.setStudentName("Feroz Ahmmed");
		review.setRoll("388372");
		review.setReview("5star");
		reviewRepository.save(review);

		Review review1 =new Review();
		review1.setStudentName("Sultana Ahmmed");
		review1.setRoll("405812");
		review1.setReview("4star");
		reviewRepository.save(review1);
		Review review2 =new Review();
		review2.setStudentName("Suriya Khatun");
		review2.setRoll("465123");
		review2.setReview("3star");
		reviewRepository.save(review2);
		Review review3 =new Review();
		review3.setStudentName("Sumiya yeasmin");
		review3.setRoll("5476154");
		review3.setReview("2star");
		reviewRepository.save(review3);
	}

}
