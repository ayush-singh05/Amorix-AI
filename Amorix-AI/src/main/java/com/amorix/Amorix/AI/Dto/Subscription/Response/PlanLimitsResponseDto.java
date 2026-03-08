package com.amorix.Amorix.AI.Dto.Subscription.Response;

public record PlanLimitsResponseDto(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}
