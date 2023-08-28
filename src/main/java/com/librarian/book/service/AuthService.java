package com.librarian.book.service;

import com.librarian.book.entity.auth.User;
import com.librarian.book.resources.auth.*;

import java.util.List;

public interface AuthService {
    UserGetResources register(UserRegisterPostResources registerPostResources);
   List<UserGetResources>getAllUser();


   UserGetResources updateUser(UserPatchResources patchResources, String id);

  User deleteUser(String id);

    AuthGetResource login(LoginPostResources post);

}
