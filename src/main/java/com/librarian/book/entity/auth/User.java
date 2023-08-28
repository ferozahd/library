package com.librarian.book.entity.auth;

import com.mongodb.client.MongoIterable;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String studentName;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id.toHexString() +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
