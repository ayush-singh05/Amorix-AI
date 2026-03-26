package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Auth.Response.AuthResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.LoginRequestDto;
import com.amorix.Amorix.AI.Dto.Auth.Request.SignupRequestDto;
import com.amorix.Amorix.AI.Entity.User;
import com.amorix.Amorix.AI.Errors.BadRequestException;
import com.amorix.Amorix.AI.Repository.UserRepository;
import com.amorix.Amorix.AI.Service.AuthService;
import com.amorix.Amorix.AI.Security.AuthUtil;
import com.amorix.Amorix.AI.Transformer.UserTransformer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    PasswordEncoder  passwordEncoder;
    AuthenticationManager authenticationManager;
    AuthUtil authUtil;

    @Override
    public AuthResponseDto login(LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateToken(user);

        return UserTransformer.userToAuthResponseDto(token,user);
    }

    @Override
    public AuthResponseDto signup( SignupRequestDto signupRequestDto) {
        userRepository.findByUsername(signupRequestDto.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with userName: " + signupRequestDto.username());
        });

        User user = UserTransformer.signUpRequestDtoToUser(signupRequestDto);

        user.setPassword(passwordEncoder.encode(signupRequestDto.password()));

        User savedUser = userRepository.save(user);
        String token = authUtil.generateToken(user);



        return UserTransformer.userToAuthResponseDto(token,savedUser);
    }
}
