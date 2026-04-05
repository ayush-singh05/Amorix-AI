package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Subscription.Request.CheckoutRequestDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.CheckoutResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.PortalResponseDto;
import com.amorix.Amorix.AI.Enum.SubscriptionStatus;
import com.amorix.Amorix.AI.Service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.Instant;

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

    @Override
    public void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId) {

    }

    @Override
    public void updateSubscription(Long id, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId) {

    }

    @Override
    public void markSubscriptionPastDue(String subId) {

    }

    @Override
    public void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd) {

    }

    @Override
    public void cancelSubscription(Long id) {

    }
}
