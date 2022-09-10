package com.sa.miniproject.one.miniprojectone.controller;

import com.sa.miniproject.one.miniprojectone.model.LoginRequest;
import com.sa.miniproject.one.miniprojectone.model.LoginResponse;
import com.sa.miniproject.one.miniprojectone.model.RefreshTokenRequest;
import com.sa.miniproject.one.miniprojectone.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@CrossOrigin
public class UaaController {
    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }
}
