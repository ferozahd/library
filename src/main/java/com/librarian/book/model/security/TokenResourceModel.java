package com.librarian.book.model.security;


import java.util.Map;


public class TokenResourceModel extends TokenClaimModel {
    private String name;
    private String email;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email =email;
    }

    public TokenResourceModel(){}
    public  TokenResourceModel(Map<String, Object> claim) {
        if (claim.containsKey(TokenClaimModel.NAME)) {
            this.name = (String) claim.get(TokenClaimModel.NAME);
        }
        if (claim.containsKey(TokenClaimModel.EMAIL)) {
            this.email = (String) claim.get(TokenClaimModel.EMAIL);
        }
    }


}
