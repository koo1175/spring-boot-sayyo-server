//package com.pj.sayyo.websocket;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pj.sayyo.model.chat.dto.ChatDto;
//import com.pj.sayyo.model.chat.dto.ChatDto.MessageType;
//import com.pj.sayyo.model.chat.dto.ChatRoom;
//import com.pj.sayyo.service.chat.ChatService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class WebSockHandler extends TextWebSocketHandler {
//    @Autowired
//    private ChatService chatService;
//    @Autowired
//    private ObjectMapper mapper;
//
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception{
//        String payload = (String) message.getPayload();
//        System.out.println("payload : "+ payload);
//
//        ChatDto chatDto = mapper.readValue(payload, ChatDto.class);
//        System.out.println("session : "+chatDto.toString());
//
//        ChatRoom room = chatService.findRoomById(chatDto.getRoomId());
//        System.out.println("room : "+room.toString());
//
//        room.handleAction(session, chatDto, chatService);
//
//    }
//
//    // 클라이언트가 접속 시 호출되는 메서드
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
//        System.out.println(session + "클라이언트 접속");
//
//    }
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception{
//        System.out.println(session + "클라이언트 접속 해제");
//    }
//
//
//
////    // 소켓 통신 시 메세지의 전송을 다루는 부분
////    @Override
////    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//////        String id = session.getId();  //메시지를 보낸 아이디
//////        String payload = message.getPayload();
//////        ChatDto chatDto = mapper.readValue(payload, ChatDto.class);
//////
//////        if (chatDto.getType() == MessageType.ENTER) {
//////            chatService.enterChat(chatDto, session);
//////        } else if (chatDto.getType() == MessageType.LEAVE) {
//////            chatService.leaveChat(chatDto, session);
//////        } else {
//////            chatService.sendMessage(chatDto);
//////        }
////        String payload = (String) message.getPayload();
////        log.info("payload : {}",payload);
////
//////        TextMessage intialGretting = new TextMessage("Welcome to Chat Server");
////        //JSON -> Java Object
////        ChatDto chatMessage = mapper.readValue(payload, ChatDto.class);
////        log.info("session : {}",chatMessage.toString());
////
////        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
////        log.info("room : {}",room.toString());
////
////        room.handleAction(session,chatMessage, service);
////    }
//}