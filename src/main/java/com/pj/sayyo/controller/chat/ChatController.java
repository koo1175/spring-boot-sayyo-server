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

@Controller
@RestController("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

//    // 메세지 전달할 경로
//    @SendTo("/topic/messages")
    @PostMapping("/send")
    @ResponseBody
    private String send(@RequestBody ChatDto chatDto) {
        int messageCount = chatService.count(chatDto);
        System.out.println("채팅을 보냅니다.");
        if(messageCount >= 100){
            chatService.deleteOldest();
            System.out.println("==============================");
            System.out.println("채팅 메세지가 100개가 넘어갔습니다.");
            System.out.println("오래된 채팅이 하나 삭제되었습니다.");
        }
        System.out.println("==============================");
        System.out.println(chatDto.toString());
        chatService.addMessage(chatDto);
        System.out.println("채팅을 보냈습니다.");
        return "메세지 전송 완료"+chatDto.toString(); // 메시지 저장
    }

    // 전체 채팅 내역 조회
    @GetMapping("/allChat")
    @ResponseBody
    public List<ChatDto> allChat(){
        List<ChatDto> messages = chatService.allChat();
        System.out.println(messages);
        return messages;
    }
}
