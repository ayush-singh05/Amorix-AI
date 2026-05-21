package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Chat.Response.StreamResponseDto;
import com.amorix.Amorix.AI.Entity.ChatSession;
import com.amorix.Amorix.AI.LLM.PromptUtils;
import com.amorix.Amorix.AI.LLM.Tools.CodeGenerationTools;
import com.amorix.Amorix.AI.Security.AuthUtil;
import com.amorix.Amorix.AI.Service.AiGenerationService;
import com.amorix.Amorix.AI.Service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiGenerationServiceImpl implements AiGenerationService {

    private final AuthUtil authUtil;
    private final ProjectFileService projectFileService;
    private final ChatClient chatClient;
    @Override
    @PreAuthorize("@Security.canEditProject(#projectId)")
    public Flux<StreamResponseDto> streamResponse(String userMessage, Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        ChatSession chatSession = createChatSessionIfNotExists(projectId, userId);
        Map<String,Object> advisorPerson = Map.of(
                "userId", userId,
                "projectId", projectId

        );
        StringBuilder fullResponseBuffer = new StringBuilder();
        CodeGenerationTools codeGenerationTools = new CodeGenerationTools(projectFileService, projectId);

        AtomicReference<Long> startTime = new AtomicReference<>(System.currentTimeMillis());
        AtomicReference<Long> endTime = new AtomicReference<>(0L);
        AtomicReference<Usage> usageRef = new AtomicReference<>();

        return chatClient.prompt()
                .system(PromptUtils.CODE_GENERATION_SYSTEM_PROMPT)
                .user(userMessage)
                .tools(codeGenerationTools)
                .advisors(advisorSpec -> {
                    advisorSpec.params(advisorParams);
                    advisorSpec.advisors(fileTreeContextAdvisor);
                })
                .stream()
                .chatResponse()
                .doOnNext(response -> {
                    String content = response.getResult().getOutput().getText();

                    if(content != null && !content.isEmpty() && endTime.get() == 0) { // first non-empty chunk received
                        endTime.set(System.currentTimeMillis());
                    }

                    if(response.getMetadata().getUsage() != null) {
                        usageRef.set(response.getMetadata().getUsage());
                    }

                    fullResponseBuffer.append(content);
                })
                .doOnComplete(() -> {
                    Schedulers.boundedElastic().schedule(() -> {
//                        parseAndSaveFiles(fullResponseBuffer.toString(), projectId);

                        long duration = (endTime.get() - startTime.get()) /  1000;
                        finalizeChats(userMessage, chatSession, fullResponseBuffer.toString(), duration, usageRef.get());
                    });
                })
                .doOnError(error -> log.error("Error during streaming for projectId: {}", projectId))
                .map(response -> {
                    String text = response.getResult().getOutput().getText();
                    return new StreamResponseDto(text != null ? text : "");
                });
    }

    private ChatSession createChatSessionIfNotExists(Long projectId, Long userId) {

    }
}
