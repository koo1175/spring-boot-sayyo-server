package com.pj.sayyo.service.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pj.sayyo.model.chat.dto.ChatDto;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private final ObjectMapper objectMapper;

    public ChatServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public int send(ChatDto chatDto) {
        return 0;
    }
}
