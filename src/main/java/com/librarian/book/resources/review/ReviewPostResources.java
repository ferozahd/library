package com.librarian.book.resources.review;

import com.librarian.book.enums.LevelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class ReviewPostResources {
    private String reviewText;
    @NotNull(message = "level must be present")
    private LevelEnum level;
//    private String bookName;
//    @NotNull(message = "student id must be present")
//    private String studentId;


}
