package com.pj.sayyo.service.chat;

import com.pj.sayyo.model.chat.dto.ChatDto;

import java.util.List;

public interface ChatService {
    ChatDto send(ChatDto chatDto);
    void addMessage(ChatDto chatDto);
    List<ChatDto> allChat();
}
