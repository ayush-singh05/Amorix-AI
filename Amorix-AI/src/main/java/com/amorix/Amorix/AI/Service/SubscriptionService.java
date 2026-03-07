package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Subscription.Request.CheckoutRequestDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.CheckoutResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.PortalResponseDto;

public interface SubscriptionService {
    SubscriptionService getMySubsciption(Long userId);

    CheckoutResponseDto createCheckoutSessionUrl(CheckoutRequestDto request, Long userId);

    PortalResponseDto openCustomerPortal(Long userId);
}
