package com.amorix.Amorix.AI.Dto.Chat.Response;

import com.amorix.Amorix.AI.Enum.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata

) {
}
