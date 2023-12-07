package com.pj.sayyo.controller.reply;


import com.pj.sayyo.model.inquiry.dto.InquiryDto;
import com.pj.sayyo.model.politician.dto.PoliticianDto;
import com.pj.sayyo.model.reply.dto.ReplyDto;
import com.pj.sayyo.service.politician.PoliticianService;
import com.pj.sayyo.service.reply.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReplyService replyService;

    @PostMapping("/regist")
    @ResponseBody
    private HashMap<String, Object> regist(@RequestBody ReplyDto replyDto){
        HashMap<String, Object> mv = new HashMap<>();
        int resultCnt = replyService.regist(replyDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);

        return mv;
    }

    @PostMapping("/findAll")
    @ResponseBody
    private HashMap<String, Object> findAll(@RequestBody ReplyDto replyDto){
        HashMap<String, Object> mv = new HashMap<>();
        List<ReplyDto> list = replyService.findAll(replyDto);

        mv.put("list", list);
        return mv;
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody ReplyDto replyDto) {
        int resultCnt2 = replyService.modify(replyDto);
        System.out.println("수정 완료 여부 : " + resultCnt2);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody ReplyDto replyDto) {
        int resultCnt3 = replyService.delete(replyDto);
        System.out.println("삭제 완료 여부 : " + resultCnt3);

    }


    @PostMapping("/isWriter")
    @ResponseBody
    public boolean isWriter(@RequestBody ReplyDto replyDto) {

        // 해당 유저가 쓴 댓글이 맞다면 true
        return replyService.isWriter(replyDto);
    }


}
