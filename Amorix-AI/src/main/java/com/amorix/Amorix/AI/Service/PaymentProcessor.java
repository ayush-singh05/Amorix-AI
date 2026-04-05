package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Subscription.Request.CheckoutRequestDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.CheckoutResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.PortalResponseDto;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {
    CheckoutResponseDto createCheckoutSessionUrl(CheckoutRequestDto request);

    PortalResponseDto openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
