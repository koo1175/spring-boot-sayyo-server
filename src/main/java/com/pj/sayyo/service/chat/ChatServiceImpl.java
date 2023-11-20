package com.pj.sayyo.service.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.model.chat.mapper.ChatMapper;
import com.pj.sayyo.websocket.SessionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private ChatMapper chatMapper;

    public void handleMessage(ChatDto chatDto) throws IOException{
        String message = chatDto.getNickname() + " : " + chatDto.getContent();
        sessionHandler.broadcast(message);
    }

    @Override
    public ChatDto send(ChatDto chatDto) {
        return chatMapper.send(chatDto);
    }
}
