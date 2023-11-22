//package com.pj.sayyo.websocket;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.*;
//
//@Configuration
//@EnableWebSocket
//@RequiredArgsConstructor
//public class WebSockConfig implements WebSocketConfigurer {
//    private final WebSockHandler webSockHandler;
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
//        // ws://port-0-spring-boot-sayyo-server-147bpb2mlmecwrp7.sel5.cloudtype.app/chatting
//        registry.addHandler(webSockHandler, "/chatting").setAllowedOrigins("*");
//    }
////    @Override
////    public void configureMessageBroker(MessageBrokerRegistry config) {
////        config.enableSimpleBroker("/topic");
////        config.setApplicationDestinationPrefixes("/app");
////    }
////
////    @Override
////    public void registerStompEndpoints(StompEndpointRegistry registry) {
////        registry.addEndpoint("/ws").withSockJS();
////    }
//}
//
