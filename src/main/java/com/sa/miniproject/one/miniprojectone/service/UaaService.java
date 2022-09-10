package com.sa.miniproject.one.miniprojectone.service;


import com.sa.miniproject.one.miniprojectone.model.LoginRequest;
import com.sa.miniproject.one.miniprojectone.model.LoginResponse;
import com.sa.miniproject.one.miniprojectone.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
