package com.pj.sayyo.service.chat;

import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.model.chat.mapper.ChatMapper;
import com.pj.sayyo.websocket.SessionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private ChatMapper chatMapper;

    private LinkedList<ChatDto> messages = new LinkedList<>();

    public void handleMessage(ChatDto chatDto) throws IOException{
        String message = chatDto.getNickname() + " : " + chatDto.getContent();
        sessionHandler.broadcast(message);
    }

    @Override
    public void addMessage(ChatDto message){
        // add가 필요할까? 잘 모르겠지만
        messages.add(message);
        chatMapper.send(message);
    }

    @Override
    public ChatDto send(ChatDto chatDto) {
        return chatMapper.send(chatDto);
    }

    @Override
    public LinkedList<ChatDto> allChat(){
        return chatMapper.allChat();
    }
    @Override
    public int deleteOldest(){
        return chatMapper.deleteOldest();
    }
    @Override
    public int count(ChatDto chatDto){
        return chatMapper.count(chatDto);
    }
}
