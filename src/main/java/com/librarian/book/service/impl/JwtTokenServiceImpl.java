package com.librarian.book.service.impl;
import com.librarian.book.exception.ResourceNotFoundException;
import com.librarian.book.model.security.TokenClaimModel;
import com.librarian.book.model.security.TokenResourceModel;
import com.librarian.book.service.JwtTokenService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;
@Service
@Slf4j
public class JwtTokenServiceImpl implements JwtTokenService {


    @Value("${jwt.token.expiration_time}")
    private int expirationTime;
    @Value("${jwt.token.secret_key}")
    private String secret;


    @Override
    public String createToken(TokenClaimModel user) {
        Map<String, Object> claim = user.getClaim();
        return Jwts.builder()
                .setSubject("Feroz")
                .setClaims(claim)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public TokenClaimModel getTokenClaimModelFromToken(String token) {
        try {
            return new TokenResourceModel((Map<String, Object>)Jwts.parserBuilder().setSigningKey(secret).build().parse(token).getBody());
        } catch (ExpiredJwtException e) {
            log.error("Token expired, please check expired time , exp");
            throw new ResourceNotFoundException("Token expired");
        } catch (Exception e) {
            log.error("Token error");
            throw new ResourceNotFoundException("Token error exception");
        }
    }


}




