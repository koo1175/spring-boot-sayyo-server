package com.pj.sayyo.controller.chat;


import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/chat")
@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;

//    // 메세지 전달할 경로
//    @SendTo("/topic/messages")
    @PostMapping("/send")
    private String send(@RequestBody ChatDto chatDto) {
        int messageCount = chatService.count(chatDto);
        if(messageCount >= 100){
            chatService.deleteOldest();
        }
        System.out.println(chatDto.toString());
        chatService.addMessage(chatDto);
        return "메세지 전송 완료"+chatDto.toString(); // 메시지 저장
    }

    // 전체 채팅 내역 조회
    @GetMapping("/allChat")
    public List<ChatDto> allChat(){
        List<ChatDto> messages = chatService.allChat();
        System.out.println(messages);
        return messages;
    }
}
