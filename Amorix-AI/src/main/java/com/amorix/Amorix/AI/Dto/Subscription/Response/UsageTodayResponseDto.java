package com.amorix.Amorix.AI.Dto.Subscription.Response;

public record UsageTodayResponseDto(
    int tokensUsed,
    int tokensLimit,
    int previewsRunning,
    int previewsLimit){

}
