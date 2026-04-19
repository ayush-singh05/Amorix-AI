package com.amorix.Amorix.AI.Dto.Subscription.Response;

import com.amorix.Amorix.AI.Dto.Plan.Response.PlanResponseDto;
import lombok.Builder;

import java.time.Instant;

@Builder
public record SubscriptionResponseDto(
        PlanResponseDto plan,
        String status,
        Instant periodEnd,
        Long tokensUsedThisCycle
) {
}