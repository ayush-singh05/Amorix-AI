package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Chat.Response.StreamResponseDto;
import reactor.core.publisher.Flux;

public interface AiGenerationService {
    Flux<StreamResponseDto> streamResponse(String message, Long projectId);
}
