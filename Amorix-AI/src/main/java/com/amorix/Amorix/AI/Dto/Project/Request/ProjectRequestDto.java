package com.amorix.Amorix.AI.Dto.Project.Request;

import com.amorix.Amorix.AI.Dto.Auth.Response.UserProfileResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Builder

public record ProjectRequestDto(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponseDto owner
) {
}
