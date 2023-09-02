package com.librarian.book.mapper;
import com.librarian.book.entity.auth.User;
import com.librarian.book.model.security.TokenResourceModel;
import com.librarian.book.resources.auth.AuthGetResource;
import com.librarian.book.resources.auth.UserGetResources;
import com.librarian.book.resources.auth.UserPatchResources;
import com.librarian.book.resources.auth.UserRegisterPostResources;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Component
@Validated
public class UserMap {
    public UserGetResources toUserRegisterGetResource(User user) {
        UserGetResources resources = new UserGetResources();
        resources.setId(user.getId().toHexString());
        resources.setStudentName(user.getStudentName());
        resources.setEmail(user.getEmail());
        return resources;
    }

    public User toUser(UserRegisterPostResources postResources) {
        User user = new User();
        user.setStudentName(postResources.getStudentName());
        user.setPassword(postResources.getPassword());
        user.setEmail(postResources.getEmail());
        return user;
    }

    public User toUser(User user, UserPatchResources patchResources) {
        user.setStudentName(patchResources.getStudentName());
        user.setPassword(patchResources.getPassword());
        user.setEmail(patchResources.getEmail());
        return user;
    }

    public TokenResourceModel toTokenResourceModel(@Valid  User user) {
        TokenResourceModel tokenResourceModel = new TokenResourceModel();
        tokenResourceModel.setName(user.getStudentName());
        tokenResourceModel.setEmail(user.getEmail());
        return tokenResourceModel;
    }

    public AuthGetResource toAuthGetResource(String token) {
        AuthGetResource resource = new AuthGetResource();
        resource.setToken(token);
        return resource;
    }
}
