package com.amorix.Amorix.AI.Dto.Member.Response;

import com.amorix.Amorix.AI.Enum.ProjectRole;

import java.time.Instant;

public record MemberResponseDto(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
){
}
