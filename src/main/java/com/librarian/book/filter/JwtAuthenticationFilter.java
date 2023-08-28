package com.librarian.book.filter;


import com.librarian.book.entity.auth.User;
import com.librarian.book.model.security.CurrentUserPrincipleModel;
import com.librarian.book.model.security.TokenClaimModel;
import com.librarian.book.repository.UserRepository;
import com.librarian.book.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.length() > 7) {
            TokenClaimModel claimModel = jwtTokenService.getTokenClaimModelFromToken(token.substring(7));
            userRepository.findByStudentName(claimModel.getName())
                    .ifPresent(setSecurityContextIfUserFound());
        }
        filterChain.doFilter(request, response);
    }




    private static Consumer<User> setSecurityContextIfUserFound() {
        return user -> {
            CurrentUserPrincipleModel principle = CurrentUserPrincipleModel.builder()
                    .name(user.getStudentName())
                    .email(user.getEmail())
                    .userId(user.getId().toHexString())
                    .build();
            Authentication authentication = new UsernamePasswordAuthenticationToken(principle, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        };
    }
}
