package com.amorix.Amorix.AI.Controller;

import com.amorix.Amorix.AI.Dto.Plan.Response.PlanResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Request.CheckoutRequestDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.CheckoutResponseDto;
import com.amorix.Amorix.AI.Dto.Subscription.Response.PortalResponseDto;
import com.amorix.Amorix.AI.Service.PlanService;
import com.amorix.Amorix.AI.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class BillingController {

    private final PlanService planService;
    private final SubscriptionService subscriptionService;
    // TODO: Get all plans
    @GetMapping("/plans")
    public ResponseEntity<List<PlanResponseDto>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllPlans());
    }

    // TODO: Get My Subscription
    @GetMapping("/me/subscription")
    public ResponseEntity<SubscriptionService> getMySubscriptions() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getMySubsciption(userId));
    }

    // TODO: Create checkout request

    @PostMapping("/stripe/checkout")
    public ResponseEntity<CheckoutResponseDto> createCheckoutResponse(
            @RequestBody CheckoutRequestDto request
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request, userId));
    }
    // TODO: Open customer portal

    @PostMapping("/stripe/portal")
    public ResponseEntity<PortalResponseDto> openCustomerPortal() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
}
