//package com.pj.sayyo.websocket;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pj.sayyo.model.chat.dto.ChatDto;
//import com.pj.sayyo.model.chat.mapper.ChatMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.io.IOException;
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
//    private final ObjectMapper mapper;
//    // 현재 연결된 세션들
//    private final Set<WebSocketSession> sessions = new HashSet<>();
//
//    // chatRoomId: {session1, session2}
//    private final Map<Long,Set<WebSocketSession>> chatRoomSessionMap = new HashMap<>();
//
//
//    private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String, WebSocketSession>();
//
//    // 소켓 연결 확인
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
////        CLIENTS.put(session.getId(), session);
//        log.info("{} 연결됨", session.getId());
//        sessions.add(session);
//    }
//
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
////        CLIENTS.remove(session.getId());
//        log.info("{} 연결 끊김", session.getId());
//        sessions.remove(session);
//    }
//
//    // 소켓 통신 시 메세지의 전송을 다루는 부분
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String id = session.getId();  //메시지를 보낸 아이디
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
//        // payload -> chatMessageDto로 변환
//        ChatDto chatDto = mapper.readValue(payload, ChatDto.class);
//        log.info("session {}", chatDto.toString());
//
//        // 메모리 상에 채팅방에 대한 세션 없으면 만들어줌
//
//        CLIENTS.entrySet().forEach( arg->{
//            if(!arg.getKey().equals(id)) {  //같은 아이디가 아니면 메시지를 전달합니다.
//                try {
//                    arg.getValue().sendMessage(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//}