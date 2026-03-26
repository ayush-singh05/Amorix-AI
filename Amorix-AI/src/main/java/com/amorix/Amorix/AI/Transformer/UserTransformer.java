package com.amorix.Amorix.AI.Transformer;

import com.amorix.Amorix.AI.Dto.Auth.Request.SignupRequestDto;
import com.amorix.Amorix.AI.Dto.Auth.Response.AuthResponseDto;
import com.amorix.Amorix.AI.Dto.Auth.Response.UserProfileResponseDto;
import com.amorix.Amorix.AI.Entity.User;

public class UserTransformer {
    public static UserProfileResponseDto userToUserResponse(User user){

        return UserProfileResponseDto.builder()
                .name(user.getName())
                .id(user.getId())
                .username(user.getUsername())
                .avatarUrl(user.getAvatar())
                .build();
    }

    public static User userProfileRequestToUser(){
        return null;
    }

    public static User signUpRequestDtoToUser(SignupRequestDto signupRequestDto) {
        return User.builder()

                .name(signupRequestDto.name())
                .username(signupRequestDto.username())
                .password(signupRequestDto.password())
                .build();
    }
    public static AuthResponseDto userToAuthResponseDto(String token,User user){
        AuthResponseDto authResponseDto = AuthResponseDto.builder()
                .token(token)
                .userProfileResponseDto(userToUserResponse(user))
                .build();
        return authResponseDto;
    }

}
