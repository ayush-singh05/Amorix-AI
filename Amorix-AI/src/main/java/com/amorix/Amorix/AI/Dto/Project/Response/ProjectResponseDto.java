package com.amorix.Amorix.AI.Dto.Project.Response;

import com.amorix.Amorix.AI.Dto.Auth.Response.UserProfileResponseDto;
import lombok.AccessLevel;
import lombok.Builder;


import java.time.Instant;



@Builder
public record ProjectResponseDto(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponseDto owner
) {
}
