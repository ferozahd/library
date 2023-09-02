package com.librarian.book.service.impl;
import com.librarian.book.entity.auth.User;
import com.librarian.book.exception.ResourceNotFoundException;
import com.librarian.book.mapper.UserMap;
import com.librarian.book.repository.ReviewRepository;
import com.librarian.book.repository.UserRepository;
import com.librarian.book.resources.auth.*;
import com.librarian.book.service.AuthService;
import com.librarian.book.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Validated
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMap userMapper;
    private final ReviewRepository reviewRepository;
    private final JwtTokenService tokenService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserGetResources register(UserRegisterPostResources registerPostResources) {
        User user = userMapper.toUser(registerPostResources);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return userMapper.toUserRegisterGetResource(user);
    }

    @Override
    public List<UserGetResources> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserRegisterGetResource)
                .collect(Collectors.toList());
    }

    @Override
    public UserGetResources updateUser(UserPatchResources patchResources, String id) {
        return userRepository.findById(new ObjectId(id))
                .map(user -> userMapper.toUser(user, patchResources))
                .map(userRepository::save)
                .map(userMapper::toUserRegisterGetResource)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    @Override
    public User deleteUser(String id) {
        reviewRepository.deleteByStudentId(id);
        return null;
    }

    @Override
    public AuthGetResource login(LoginPostResources post) {
        return userRepository.findByEmail(post.getEmail())
                .filter(user -> (passwordEncoder.matches(post.getPassword(), user.getPassword())))
                .map(userMapper::toTokenResourceModel)
                .map(tokenService::createToken)
                .map(userMapper::toAuthGetResource)
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));
    }




}
