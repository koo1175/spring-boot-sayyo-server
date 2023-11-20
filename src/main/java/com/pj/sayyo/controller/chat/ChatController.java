package com.pj.sayyo.controller.chat;


import com.pj.sayyo.model.chat.dto.ChatDto;
import com.pj.sayyo.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    @ResponseBody
    private HashMap<String, Object> send(@RequestBody ChatDto chatDto){
        HashMap<String, Object> mv = new HashMap<>();

        int resultCnt = chatService.send(chatDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);

        return mv;
    }
}
