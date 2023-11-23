//package com.pj.sayyo.service.chat;
//
//import com.pj.sayyo.model.chat.dto.ChatDto;
//import com.pj.sayyo.model.chat.dto.ChatRoom;
//import org.springframework.web.socket.WebSocketSession;
//
//import java.util.List;
//
//public interface ChatService {
//    void addMessage(ChatDto chatDto);
//    List<ChatDto> allChat();
//    int deleteOldest();
//    int count(ChatDto chatDto);
//
//    // websocket
//    void enterChat(ChatDto chatDto, WebSocketSession session);
//    void leaveChat(ChatDto chatDto, WebSocketSession session);
//    <T> void sendMessage(WebSocketSession session, T message);
//    ChatRoom findRoomById(String roomId);
//    ChatRoom createRoom();
//}
