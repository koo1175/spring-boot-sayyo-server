package com.pj.sayyo.service.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.websocket.SessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private SessionHandler sessionHandler;

    public void handleMessage(ChatDto chatDto) throws IOException{
        String message = chatDto.getNickname() + " : " + chatDto.getContent();
        sessionHandler.broadcast(message);
    }

    @Override
    public ChatDto send(ChatDto chatDto) {
        return chatDto;
    }
}
