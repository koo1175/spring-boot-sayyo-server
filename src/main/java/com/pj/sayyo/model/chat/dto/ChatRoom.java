//package com.pj.sayyo.model.chat.dto;
//
//import com.pj.sayyo.service.chat.ChatService;
//import lombok.Builder;
//import lombok.Data;
//import org.springframework.web.socket.WebSocketSession;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Data
//public class ChatRoom {
//    private String roomId;
//    private Set<WebSocketSession> sessions = new HashSet<>();
//
//    @Builder
//    public ChatRoom(String roomId){
//        this.roomId = roomId;
//    }
//    public void handleAction(WebSocketSession session, ChatDto message, ChatService service){
//        if(message.getType().equals(ChatDto.MessageType.ENTER)){
//            sessions.add(session);
//
//            message.setContent(message.getNickname()+"님이 입장했습니다.");
//            sendMessage(message, service);
//        }else if(message.getType().equals(ChatDto.MessageType.TALK)){
//            message.setContent(message.getContent());
//            sendMessage(message, service);
//        }
//    }
//    public <T> void sendMessage(T message, ChatService service){
//        sessions.parallelStream().forEach(sessions -> service.sendMessage(sessions, message));
//    }
//}
