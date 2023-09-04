package com.librarian.book.entity.auth;

import com.mongodb.client.MongoIterable;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    @NotNull(message = "Student name will not null , Fatal error")
    private String studentName;
    private String password;
    @NotNull(message = "Email will not null , Fatal error")
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
