package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Auth.Response.AuthResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.LoginRequestDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.SignupRequestDto;
import org.springframework.stereotype.Service;


public interface AuthService {
    AuthResponseDto login(LoginRequestDto request);

    AuthResponseDto signup(SignupRequestDto signupRequestDto);
}
