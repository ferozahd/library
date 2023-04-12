package com.librarian.book.entity.auth;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
public class User {
    @Id
    private ObjectId id;
    private  String studentName;
    private String password;
    private String email;


}
