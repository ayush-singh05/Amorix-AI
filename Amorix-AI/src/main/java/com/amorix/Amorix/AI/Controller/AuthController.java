package com.amorix.Amorix.AI.Controller;

import com.amorix.Amorix.AI.Dto.Auth.Response.AuthResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.LoginRequestDto;
import com.amorix.Amorix.AI.Dto.Auth.Response.ProfileResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.SignupRequestDto;
import com.amorix.Amorix.AI.Service.AuthService;
import com.amorix.Amorix.AI.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(SignupRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.signup(signupRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(LoginRequestDto request){
        return ResponseEntity.ok( authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<ProfileResponseDto> getProfile(){
        return ResponseEntity.ok(userService.getProfile());
    }
}
