//package com.librarian.book.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.TestingAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (authorization != null) {
//            authorization = authorization.substring(7);
//            if (authorization.equals("sultana")) {
//
//                Authentication authentication = new UsernamePasswordAuthenticationToken(null, null, null);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            }
//        }
//
//
//        filterChain.doFilter(request, response);
//    }
//}
