package com.amorix.Amorix.AI.Dto.Member.Request;

import com.amorix.Amorix.AI.Enum.ProjectRole;

public record InviteMemberRequestDto(
        String email,
        ProjectRole role
) {
}
