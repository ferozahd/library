package com.librarian.book.resources.review;

import com.librarian.book.enums.ReviewEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReviewPostResources {
    private String studentName;
    private String roll;
    private ReviewEnum review;
    private String bookName;
}
