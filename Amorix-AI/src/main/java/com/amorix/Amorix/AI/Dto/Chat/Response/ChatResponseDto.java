package com.amorix.Amorix.AI.Dto.Chat.Response;

import com.amorix.Amorix.AI.Enum.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponseDto(
        Long id,
        MessageRole role,
        List<ChatEventResponse> events,
        String content,
        Integer tokensUsed,
        Instant createdAt
) {
}
