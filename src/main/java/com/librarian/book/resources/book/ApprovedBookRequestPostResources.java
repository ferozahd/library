package com.librarian.book.resources.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovedBookRequestPostResources {
    private String bookName;
    private String requestBy;
    private String oparation;
}
