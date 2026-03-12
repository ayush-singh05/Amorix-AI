package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Auth.Response.AuthResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.LoginRequestDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.SignupRequestDto;
import com.amorix.Amorix.AI.Service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponseDto login(LoginRequestDto request) {
        return null;
    }

    @Override
    public AuthResponseDto signup(SignupRequestDto signupRequestDto) {
        return null;
    }
}
