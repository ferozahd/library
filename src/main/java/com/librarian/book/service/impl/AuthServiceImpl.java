package com.librarian.book.service.impl;

import com.librarian.book.resources.auth.AuthResponse;
import com.librarian.book.resources.auth.LoginPostResources;
import com.librarian.book.service.AuthService;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse login(LoginPostResources loginpostResources) {
//
//        CompanyServiceDetails company = (CompanyServiceDetails) this.companyUserServiceDetails.loadUserByUsername(login.getEmail());
//        if(!passwordEncoder.matches(login.getPassword(),company.getPassword()))
//            throw new BadCredentialsException("Bad credentials");
//
//        final Authentication authentication = new UsernamePasswordAuthenticationToken(company, null, company.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        final String token = jwtService.generateTokenForCompany(authentication);
//        return new TokenResource(token);
        return null;
    }
}
