package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Auth.Request.AuthResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.LoginRequestDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.SignupRequestDto;

public interface AuthService {
    AuthResponseDto login(LoginRequestDto request);

    AuthResponseDto signup(SignupRequestDto signupRequestDto);
}
