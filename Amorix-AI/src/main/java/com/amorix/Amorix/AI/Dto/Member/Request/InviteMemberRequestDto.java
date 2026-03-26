package com.amorix.Amorix.AI.Dto.Member.Request;

import com.amorix.Amorix.AI.Enum.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequestDto(
        @Email @NotBlank String username,
       @NotNull ProjectRole role
) {
}
