package com.amorix.Amorix.AI.Controller;

import com.amorix.Amorix.AI.Dto.Chat.Request.ChatRequestDto;
import com.amorix.Amorix.AI.Dto.Chat.Response.ChatResponseDto;
import com.amorix.Amorix.AI.Dto.Chat.Response.StreamResponseDto;
import com.amorix.Amorix.AI.Service.AiGenerationService;
import com.amorix.Amorix.AI.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final AiGenerationService aiGenerationService;
    ChatService chatService;

    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<StreamResponseDto>> streamChat(@RequestBody ChatRequestDto requestDto) {
        return aiGenerationService.streamResponse(requestDto.message(), requestDto.projectId())
                .map(data -> ServerSentEvent.<StreamResponseDto>builder()
                        .data(data)
                        .build());
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<List<ChatResponseDto>> getChatHistory(
            @PathVariable Long projectId) {

        return ResponseEntity.ok(chatService.getProjectChatHistory(projectId));
    }
}
