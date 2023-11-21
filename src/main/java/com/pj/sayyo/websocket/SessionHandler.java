package com.pj.sayyo.websocket;

import com.pj.sayyo.model.chat.dto.ChatDto;
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
    private static final int MAX_MESSAGES = 500;

    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private List<ChatDto> messages = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{

        sessions.add(session);
        for (ChatDto message : messages){
            session.sendMessage(new TextMessage(message.getNickname() + ": " + message.getContent()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        sessions.remove(session);
    }

    public void addMessage(ChatDto chatDto) throws IOException {
        // 메세지 갯수를 500개로 제한함 ( 휘발성 메세지 )
        messages.add(chatDto);
        if (messages.size() > MAX_MESSAGES) {
            messages.remove(0);
        }
        broadcast(chatDto.getNickname() + ": " + chatDto.getContent());
    }

    public void broadcast(String message) throws IOException {
        TextMessage textMessage = new TextMessage(message);
        for (WebSocketSession webSocketSession : sessions) {
            webSocketSession.sendMessage(textMessage);
        }
    }
}
