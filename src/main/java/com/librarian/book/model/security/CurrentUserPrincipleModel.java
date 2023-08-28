package com.librarian.book.model.security;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrentUserPrincipleModel {
    private String name;
    private String email;
    private String userId;
}
