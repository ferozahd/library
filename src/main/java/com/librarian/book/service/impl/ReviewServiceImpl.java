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
import com.librarian.book.service.JwtTokenService;
import com.librarian.book.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final AuthService authService;
    private final CommonService commonService;

    //autowired or requiredarugmentcontactor or next line

    @Override
    public ReviewGetResources create(ReviewPostResources reviewPostResources) {
        User user = userRepository.findById(new ObjectId(commonService.getId())).orElseThrow(() -> new ResourceNotFoundException("user not found"));
                    Review review = reviewMapper.toReviewWithStudent(reviewPostResources);
                    reviewRepository.save(review);
                    return reviewMapper.toReviewGetResource(user,review);



//        return userRepository.findById(new ObjectId(reviewPostResources.getStudentId()))
//                .map(student -> {
//                    Review review = reviewMapper.toReviewWithStudent(student, reviewPostResources);
//                    reviewRepository.save(review);
//                    return reviewMapper.toReviewGetResource(student, review);
//                }).orElseThrow(() -> new ResourceNotFoundException("Student not found , Taile k review dicche"));

    }

    @Override
    public List<ReviewGetResources> getAll() {
        return reviewRepository.findAll()
                .stream()
                .map(
                        review -> {
                            User student = userRepository.findById(new ObjectId(commonService.getId())).get();
                            return reviewMapper.toReviewGetResource(student, review);
                        }
                ).toList();
    }

    @Override
    public List<ReviewGetResources> getReviewDetailsByUserId(String id) {
        return reviewRepository.findByStudentId(id)
                .stream()
                .map(
                        review -> {
                            User student = userRepository.findById(new ObjectId(id)).get();
                            return reviewMapper.toReviewGetResource(student, review);
                        }
                ).toList();

    }


}
