package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Subscription.Response.PlanLimitsResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.UsageTodayResponseDto;
import com.amorix.Amorix.AI.Service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponseDto getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponseDto getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
