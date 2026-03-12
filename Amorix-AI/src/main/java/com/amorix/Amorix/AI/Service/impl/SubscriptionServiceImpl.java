package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Subscription.Request.CheckoutRequestDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.CheckoutResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.PortalResponseDto;
import com.amorix.Amorix.AI.Service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionService getMySubsciption(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponseDto createCheckoutSessionUrl(CheckoutRequestDto request, Long userId) {
        return null;
    }

    @Override
    public PortalResponseDto openCustomerPortal(Long userId) {
        return null;
    }
}
