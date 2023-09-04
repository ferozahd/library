package com.librarian.book.service;


import com.librarian.book.model.security.TokenClaimModel;

import javax.validation.Valid;


public interface JwtTokenService {
    String createToken(TokenClaimModel user);

    /**
     * {@params String token}
     * return String student name from token | Exception {student name not found}
     */
     TokenClaimModel getTokenClaimModelFromToken(String token);
}
