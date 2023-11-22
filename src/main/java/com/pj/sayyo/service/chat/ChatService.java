package com.pj.sayyo.service.chat;

import com.pj.sayyo.model.chat.dto.ChatDto;

import java.util.List;

public interface ChatService {
    void addMessage(ChatDto chatDto);
    List<ChatDto> allChat();
    int deleteOldest();
    int count(ChatDto chatDto);
}
