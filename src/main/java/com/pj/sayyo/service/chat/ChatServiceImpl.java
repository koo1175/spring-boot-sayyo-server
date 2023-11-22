package com.pj.sayyo.service.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.model.chat.mapper.ChatMapper;
import com.pj.sayyo.websocket.SessionHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Data
@Service
public class ChatServiceImpl implements ChatService{

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    // 채팅방
//    private Map<String, ChatRoom> chatRooms;
    private ObjectMapper mapper;
    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private ChatMapper chatMapper;
//    // ?
//    @PostConstruct
//    private void init(){
//        chatRooms = new LinkedHashMap<>();
//    }

    @Override
    public void addMessage(ChatDto message){
        chatMapper.send(message);
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

//    // websocket
//    @Override
//    public void enterChat(ChatDto chatDto, WebSocketSession session) {
//        sessions.put(chatDto.getNickname(), session);
//    }
//
//    @Override
//    public void leaveChat(ChatDto chatDto, WebSocketSession session) {
//        sessions.remove(chatDto.getNickname());
//    }
//
//    @Override
//    public <T> void sendMessage(WebSocketSession session, T message){
//        try{
//            session.sendMessage(new TextMessage(mapper.writeValueAsString(message)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public ChatRoom findRoomById(String roomId){
//        return chatRooms.get(roomId);
//    }
//    @Override
//    public ChatRoom createRoom(){
//        String roomId = UUID.randomUUID().toString();
//
//        ChatRoom room = ChatRoom.builder()
//                .roomId(roomId)
//                .build();
//        chatRooms.put(roomId, room);
//        return room;
//    }


}
