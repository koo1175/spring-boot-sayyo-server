//package com.pj.sayyo.websocket;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@RequiredArgsConstructor
//@Slf4j
//@EnableWebSocket
//public class WebSockConfig implements WebSocketConfigurer {
//
//    private final WebSockHandler webSockHandler;
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
//        // ws://port-0-spring-boot-sayyo-server-147bpb2mlmecwrp7.sel5.cloudtype.app/chatting
//        registry.addHandler(webSockHandler, "ws/chatting").setAllowedOrigins("*");
//    }
//
//}
//
