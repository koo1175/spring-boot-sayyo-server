package com.pj.sayyo.websocket;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Set;



@RequiredArgsConstructor
@Component
public class WebSockChatHandler extends TextWebSocketHandler {
    // 서버와 클라이언트가 1:N으로 관계를 맺는다.
    // 한 서버에 여러 클라이언트가 접속할 수 있다.
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
    @Autowired
    private SessionHandler sessionHandler;

    Logger log = LoggerFactory.getLogger(this.getClass());


    private  void sendToEachSocket(Set<WebSocketSession> sessions, TextMessage message){
        sessions.parallelStream().forEach( roomSession -> {
            try {
                roomSession.sendMessage(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        String payload = message.getPayload();
        log.info("payload {}", payload);
        sessionHandler.broadcast(payload);
    }

}
