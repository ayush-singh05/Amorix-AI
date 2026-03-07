package com.amorix.Amorix.AI.Dto.Auth.Request;

public record AuthResponseDto(
        String token,
        UserProfileResponse userProfileResponse
) {
}
