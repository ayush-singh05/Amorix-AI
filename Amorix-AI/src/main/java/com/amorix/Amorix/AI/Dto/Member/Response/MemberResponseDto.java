package com.amorix.Amorix.AI.Dto.Member.Response;

import com.amorix.Amorix.AI.Enum.ProjectRole;
import lombok.Builder;

import java.time.Instant;

@Builder
public record MemberResponseDto(
        Long userId,
        String username,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
){
}
