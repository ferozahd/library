package com.librarian.book.entity;

import com.librarian.book.enums.ReviewEnum;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "review")
public class Review {
    @Id
    private ObjectId id;
    private String studentName;
    private String roll;
    private ReviewEnum review;

    private String bookName;



}
