package com.sa.miniproject.one.miniprojectone.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
