package com.pj.sayyo.websocket;

import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class WebSockHandler extends TextWebSocketHandler {
    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("payload : " + payload);

        // payload를 JSON으로 파싱
        JSONObject jsonPayload = new JSONObject(payload);

        // content와 nickname을 추출
        String content = jsonPayload.getString("content");
        String nickname = jsonPayload.getString("nickname");

        // 새로운 payload를 생성
        JSONObject newPayload = new JSONObject();
        newPayload.put("content", content);
        newPayload.put("nickname", nickname);

        TextMessage newMessage = new TextMessage(newPayload.toString());

        for(WebSocketSession sess: list) {
            sess.sendMessage(newMessage);
        }
    }

    // Client 접속 시 호출되는 메서드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        list.add(session);

        System.out.println(session + " 클라이언트 접속");
    }

    // Client 접속 해제 시 호출되는 메서드

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        System.out.println(session + " 클라이언트 접속 해제");
        list.remove(session);
    }
}