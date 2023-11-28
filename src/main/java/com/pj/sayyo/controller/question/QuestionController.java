package com.pj.sayyo.controller.question;


import com.pj.sayyo.model.question.dto.QuestionDto;
import com.pj.sayyo.service.question.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionService questionService;

    @PostMapping("/regist")
    @ResponseBody
    private HashMap<String, Object> regist(@RequestBody QuestionDto questionDto){
        HashMap<String, Object> mv = new HashMap<>();

        int resultCnt = questionService.regist(questionDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);

        return mv;
    }

    @GetMapping("/findAll")
    @ResponseBody
    private HashMap<String, Object> findAll(){
        HashMap<String, Object> mv = new HashMap<>();
        List<QuestionDto> list = questionService.findAll();

        mv.put("list", list);
        return mv;
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody QuestionDto questionDto) {
        int resultCnt2 = questionService.modify(questionDto);
        System.out.println("수정 완료 여부 : " + resultCnt2);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody QuestionDto questionDto) {
        int resultCnt3 = questionService.delete(questionDto);
        System.out.println("삭제 완료 여부 : " + resultCnt3);

    }

    @GetMapping("/findSearch")
    @ResponseBody
    public void selectFind(@RequestBody QuestionDto questionDto) {
        HashMap<String, Object> mv = new HashMap<>();
        List<QuestionDto> list = questionService.findSearch(questionDto);

        mv.put("list", list);
    }

    @GetMapping("/isCorrect")
    @ResponseBody
    public boolean isCorrect(@RequestBody QuestionDto questionDto) {
        // 유저한테는 질문과 정답을 요청받은 뒤 isCorrect로 확인하도록 함
        // 정답일 경우 true 반환
        // 오답일 경우 false 반환

        boolean resultCnt = questionService.isCorrect(questionDto);
        System.out.println("정답 일 때 true : " + resultCnt);

        return resultCnt;
    }
}
