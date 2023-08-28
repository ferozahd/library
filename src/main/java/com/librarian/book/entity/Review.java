package com.librarian.book.entity;

import com.librarian.book.enums.LevelEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String studentId;
    private String reviewText;
    private LevelEnum level;



//    private String bookName;


    @Override
    public String toString() {
        return "new Review(" +
                "new ObjectId(\"" + id +
                "\"),\"" + studentId + '\"' +
                ",\"" + reviewText + "\",LevelEnum." + level +
                "),";
    }


}
