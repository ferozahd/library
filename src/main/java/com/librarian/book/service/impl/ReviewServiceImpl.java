package com.librarian.book.service.impl;
import com.librarian.book.entity.Review;
import com.librarian.book.entity.auth.User;
import com.librarian.book.exception.ResourceNotFoundException;
import com.librarian.book.mapper.ReviewMapper;
import com.librarian.book.repository.ReviewRepository;
import com.librarian.book.repository.UserRepository;
import com.librarian.book.resources.review.ReviewGetResources;
import com.librarian.book.resources.review.ReviewPostResources;
import com.librarian.book.service.AuthService;
import com.librarian.book.service.CommonService;
import com.librarian.book.service.ReviewService;
import com.librarian.book.utiles.VariableUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final CommonService commonService;
    private final MongoTemplate mongoTemplate;


    @Override
    public ReviewGetResources create(ReviewPostResources reviewPostResources) {
        User user = userRepository.findById(new ObjectId(commonService.getId())).orElseThrow(() -> new ResourceNotFoundException("user not found"));
                    Review review = reviewMapper.toReviewWithStudent(reviewPostResources);
                  review.setStudentId(user.getId().toHexString());
                    reviewRepository.save(review);
                    return reviewMapper.toReviewGetResource(user,review);

    }

    @Override
    public List<ReviewGetResources> getAll() {
        log.info("################################   GET ALL ###################################");
//        return reviewRepository.findAll()
//                .stream()
//                .map(
//                        review -> {
//                            User student = userRepository.findById(new ObjectId(review.getStudentId())).get();
//                            return reviewMapper.toReviewGetResource(student, review);
//                        }
//                ).toList();


        // solution number 1
        List<Review> reviews = reviewRepository.findAll();
        List<User> users = userRepository.findByIdIn(reviews.stream().map(Review::getStudentId).map(ObjectId::new).collect(Collectors.toSet()));

        return reviews.stream().map(review ->
                             reviewMapper.toReviewGetResource(users.stream().filter(u->u.getId().toHexString().equals(review.getStudentId())).findFirst().get(), review)
        ).collect(Collectors.toList());


    }

    @Override
    public List<ReviewGetResources> getReviewDetailsByCurrentUser() {
        return reviewRepository.findByStudentId(commonService.getId())
                .stream()
                .map(
                        review -> {
                            User student = userRepository.findById(new ObjectId(review.getStudentId())).get();
                            return reviewMapper.toReviewGetResource(student, review);
                        }
                ).toList();

    }

    @Override
    public ReviewGetResources findById(String reviewId) {
        return reviewRepository.findById(VariableUtils.strToObjId(reviewId))
                .map(  review -> {
                    User student = userRepository.findById(new ObjectId(review.getStudentId())).get();
                    return reviewMapper.toReviewGetResource(student, review);
                })
                .orElseThrow(()->new ResourceNotFoundException("Review Not found"));
    }


}
