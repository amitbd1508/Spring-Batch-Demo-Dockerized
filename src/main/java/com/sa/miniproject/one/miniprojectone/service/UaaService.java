package com.sa.miniproject.one.miniprojectone.service;


import com.sa.miniproject.one.miniprojectone.dto.LoginRequest;
import com.sa.miniproject.one.miniprojectone.dto.LoginResponse;
import com.sa.miniproject.one.miniprojectone.dto.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
