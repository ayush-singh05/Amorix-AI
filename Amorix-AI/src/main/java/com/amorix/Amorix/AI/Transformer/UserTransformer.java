package com.amorix.Amorix.AI.Transformer;

import com.amorix.Amorix.AI.Dto.Auth.Response.UserProfileResponseDto;
import com.amorix.Amorix.AI.Entity.User;

public class UserTransformer {
    public static UserProfileResponseDto userToUserResponse(User user){

        return UserProfileResponseDto.builder()
                .name(user.getName())
                .id(user.getId())
                .email(user.getEmail())
                .avatarUrl(user.getAvatar())
                .build();
    }

    public static User userProfileRequestToUser(){
        return null;
    }
}
