package com.amorix.Amorix.AI.Dto.Project.Response;

import com.amorix.Amorix.AI.Enum.ProjectRole;
import lombok.Builder;

import java.time.Instant;

@Builder
public record ProjectSummaryResponseDto(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
