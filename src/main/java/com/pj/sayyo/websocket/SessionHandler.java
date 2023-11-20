package com.pj.sayyo.websocket;

import org.apache.logging.log4j.spi.CopyOnWrite;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SessionHandler extends TextWebSocketHandler {

    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        sessions.remove(session);
    }

    public void broadcast(String message) throws IOException {
        TextMessage textMessage = new TextMessage(message);
        for (WebSocketSession webSocketSession : sessions) {
            webSocketSession.sendMessage(textMessage);
        }
    }
}
