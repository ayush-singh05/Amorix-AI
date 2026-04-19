package com.amorix.Amorix.AI.Transformer;

import com.amorix.Amorix.AI.Dto.Plan.Response.PlanResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.SubscriptionResponseDto;
import com.amorix.Amorix.AI.Entity.Plan;
import com.amorix.Amorix.AI.Entity.Subscription;

public class SubscriptionTransformer {

    public static SubscriptionResponseDto subscriptionToSubscriptionResponseDto(Subscription subscription) {
        SubscriptionResponseDto build = SubscriptionResponseDto.builder()
                .plan(planToPlanResponseDto(subscription.getPlan()))
                .status(subscription.getStatus().toString())
                .periodEnd(subscription.getCurrentPeriodEnd())
                .build();
        return build;
    }
    public static PlanResponseDto planToPlanResponseDto(Plan plan) {
        return PlanResponseDto.builder()
                .id(plan.getId())
                .name(plan.getName())
                .maxProjects(plan.getMaxProjects())
                .maxTokensPerDay(plan.getMaxTokenPerDay())
                .unlimitedAi(plan.getUnlimitedAi())
                .price(plan.getStripePriceId())
                .build();


    }
}
