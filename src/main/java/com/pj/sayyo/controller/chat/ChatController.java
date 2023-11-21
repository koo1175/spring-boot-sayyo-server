package com.pj.sayyo.controller.chat;


import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    // 메세지 전달할 경로
    @SendTo("/send/message")
    @ResponseBody
    private String send(@RequestBody ChatDto chatDto) {
        System.out.println(chatDto.toString());
        chatService.addMessage(chatDto);
        return "메세지 전송 완료"+chatDto.toString(); // 메시지 저장
    }

    // 전체 채팅 내역 조회
    @GetMapping("/allChat")
    public ResponseEntity<List<ChatDto>> allChat(){
        List<ChatDto> messages = chatService.allChat();
        return ResponseEntity.ok(messages);
    }
}
