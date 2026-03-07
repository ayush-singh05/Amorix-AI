package com.amorix.Amorix.AI.Dto.Plan.Response;

public record PlanResponseDto(Long id,
                              String name,
                              Integer maxProjects,
                              Integer maxTokensPerDay,
                              Boolean unlimitedAi,
                              String price) {
}
