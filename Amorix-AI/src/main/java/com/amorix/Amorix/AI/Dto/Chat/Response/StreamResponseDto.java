package com.amorix.Amorix.AI.Dto.Chat.Response;

import java.time.Instant;

public record StreamResponseDto(
        Long id,
        MessageRole role,
        List<ChatEventResponse> events,
        String content,
        Integer tokensUsed,
        Instant createdAt
) {
}
