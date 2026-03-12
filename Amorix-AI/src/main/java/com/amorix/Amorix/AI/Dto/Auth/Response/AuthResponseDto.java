package com.amorix.Amorix.AI.Dto.Auth.Response;

public record AuthResponseDto(
        String token,
        UserProfileResponseDto userProfileResponseDto
) {
}
