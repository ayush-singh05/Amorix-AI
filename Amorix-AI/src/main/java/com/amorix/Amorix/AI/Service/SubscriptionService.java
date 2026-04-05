package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Subscription.Request.CheckoutRequestDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.CheckoutResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.PortalResponseDto;
import com.amorix.Amorix.AI.Enum.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    SubscriptionService getMySubsciption(Long userId);

    CheckoutResponseDto createCheckoutSessionUrl(CheckoutRequestDto request, Long userId);

    PortalResponseDto openCustomerPortal(Long userId);

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(Long id, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void markSubscriptionPastDue(String subId);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    void cancelSubscription(Long id);

}
