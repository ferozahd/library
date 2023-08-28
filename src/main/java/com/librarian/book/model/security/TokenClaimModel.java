package com.librarian.book.model.security;

import java.util.HashMap;
import java.util.Map;

public abstract  class TokenClaimModel {
    protected static final String NAME ="name";
    protected static final String EMAIL ="email";

    public abstract String getName();
    public abstract String getEmail();

    public Map<String,Object> getClaim(){
      Map<String,Object> claim = new HashMap<>();
      claim.put(NAME,getName());
      claim.put(EMAIL,getEmail());
      return claim;
    }

}
