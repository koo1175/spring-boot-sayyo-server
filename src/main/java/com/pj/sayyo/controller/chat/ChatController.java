package com.pj.sayyo.controller.chat;


import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    @ResponseBody
    private ChatDto send(@RequestBody ChatDto chatDto) throws IOException {
        return chatService.send(chatDto);
    }
}
