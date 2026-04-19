package com.amorix.Amorix.AI.Dto.Plan.Response;

import lombok.Builder;

@Builder
public record PlanResponseDto(
                              Long id,
                              String name,
                              Integer maxProjects,
                              Integer maxTokensPerDay,
                              Boolean unlimitedAi,
                              String price) {
}
