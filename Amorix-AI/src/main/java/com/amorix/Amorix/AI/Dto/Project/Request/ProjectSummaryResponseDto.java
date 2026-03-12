package com.amorix.Amorix.AI.Dto.Project.Request;

import lombok.Builder;

import java.time.Instant;

@Builder
public record ProjectSummaryResponseDto(
        Long id,
        String projectName,
        Instant createdAt,
        Instant updatedAt
        ) {
}
