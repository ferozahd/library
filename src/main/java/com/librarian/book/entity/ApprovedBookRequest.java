package com.librarian.book.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "approvedBook")
public class ApprovedBookRequest {
    @Id
    private ObjectId id;
    private String bookName;
    private String requestBy;
    private String oparation;
}
