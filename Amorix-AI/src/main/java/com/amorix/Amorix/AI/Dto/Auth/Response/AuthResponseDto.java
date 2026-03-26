package com.amorix.Amorix.AI.Dto.Auth.Response;

import lombok.Builder;

@Builder
public record AuthResponseDto(
        String token,
        UserProfileResponseDto userProfileResponseDto
) {
}
