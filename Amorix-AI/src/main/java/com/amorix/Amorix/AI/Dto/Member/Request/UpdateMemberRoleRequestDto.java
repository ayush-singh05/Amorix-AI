package com.amorix.Amorix.AI.Dto.Member.Request;

import com.amorix.Amorix.AI.Enum.ProjectRole;
import org.antlr.v4.runtime.misc.NotNull;

public record UpdateMemberRoleRequestDto(
        @NotNull ProjectRole role
) {
}
