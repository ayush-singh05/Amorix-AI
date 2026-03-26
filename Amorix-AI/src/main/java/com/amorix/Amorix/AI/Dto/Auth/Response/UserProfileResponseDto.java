package com.amorix.Amorix.AI.Dto.Auth.Response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;


@Builder
public record UserProfileResponseDto(
        Long id,
        String username,
        String name,
        String avatarUrl
) {
}
