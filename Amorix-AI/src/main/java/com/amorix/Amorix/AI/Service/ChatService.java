package com.amorix.Amorix.AI.Service;



import com.amorix.Amorix.AI.Dto.Chat.Response.ChatResponseDto;

import java.util.List;

public interface ChatService {
    List<ChatResponseDto> getProjectChatHistory(Long projectId);
}
