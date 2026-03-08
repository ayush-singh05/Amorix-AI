package com.amorix.Amorix.AI.Dto.Subscription.Response;

public record PlanLimitResponseDto(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}
