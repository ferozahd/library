package com.librarian.book.service;

import com.librarian.book.resources.auth.AuthResponse;
import com.librarian.book.resources.auth.LoginPostResources;

public interface AuthService {
    AuthResponse login(LoginPostResources loginpostResources);
}
