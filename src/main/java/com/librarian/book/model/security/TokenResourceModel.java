package com.librarian.book.model.security;


import lombok.Data;
import java.util.Map;

@Data
public class TokenResourceModel extends TokenClaimModel {

    private String name;

    private String email;


    public TokenResourceModel() {
    }

    public TokenResourceModel(Map<String, Object> claim) {
        if (claim.containsKey(TokenClaimModel.NAME)) {
            this.name = (String) claim.get(TokenClaimModel.NAME);
        }
        if (claim.containsKey(TokenClaimModel.EMAIL)) {
            this.email = (String) claim.get(TokenClaimModel.EMAIL);
        }
    }


}
