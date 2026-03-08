package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Subscription.Response.PlanLimitsResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.UsageTodayResponseDto;

public interface UsageService {
    UsageTodayResponseDto getTodayUsageOfUser(Long userId);

    PlanLimitsResponseDto getCurrentSubscriptionLimitsOfUser(Long userId);
}
