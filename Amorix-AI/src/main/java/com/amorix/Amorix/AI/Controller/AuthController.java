package com.amorix.Amorix.AI.Controller;

import com.amorix.Amorix.AI.Dto.Auth.Response.AuthResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.LoginRequestDto;
import com.amorix.Amorix.AI.Dto.Auth.Response.ProfileResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.SignupRequestDto;
import com.amorix.Amorix.AI.Service.AuthService;
import com.amorix.Amorix.AI.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.signup(signupRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto request){
        return ResponseEntity.ok( authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<ProfileResponseDto> getProfile(){
        return ResponseEntity.ok(userService.getProfile());
    }
}
