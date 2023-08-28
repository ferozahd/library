package com.librarian.book.resources.review;

import com.librarian.book.entity.Review;
import com.librarian.book.enums.LevelEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewGetResources {
    private String id;
    private String  studentId;
    private String reviewText;
    private LevelEnum  level;
    private String studentName;
    private String email;

    @Override
    public String toString() {
        return "ReviewGetResources{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", level=" + level +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
