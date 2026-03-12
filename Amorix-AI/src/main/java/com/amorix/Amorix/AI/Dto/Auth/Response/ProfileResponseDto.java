package com.amorix.Amorix.AI.Dto.Auth.Response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder

public record ProfileResponseDto(
        String email,
        String name
) {
}
