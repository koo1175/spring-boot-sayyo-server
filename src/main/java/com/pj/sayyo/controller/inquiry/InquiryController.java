package com.pj.sayyo.controller.inquiry;

import com.pj.sayyo.model.inquiry.dto.InquiryDto;
import com.pj.sayyo.model.inquiry.dto.InquiryReDto;
import com.pj.sayyo.model.member.dto.MemberDto;
import com.pj.sayyo.service.inquiry.InquiryService;
import com.pj.sayyo.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/regist")
    @ResponseBody
    private HashMap<String, Object> regist(@RequestBody InquiryDto inquiryDto){
        HashMap<String, Object> mv = new HashMap<>();

        int resultCnt = inquiryService.regist(inquiryDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);
        return mv;
    }

    @GetMapping("/findAll")
    @ResponseBody
    private HashMap<String, Object> findAll(){
        HashMap<String, Object> mv = new HashMap<>();
        List<InquiryDto> list = inquiryService.findAll();

        mv.put("list", list);
        return mv;
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody InquiryDto inquiryDto) {
        int resultCnt2 = inquiryService.modify(inquiryDto);
        System.out.println("문의 내역 수정 완료 여부 : " + resultCnt2);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody InquiryDto inquiryDto) {
        int resultCnt3 = inquiryService.delete(inquiryDto);
        System.out.println("문의 내역 삭제 완료 여부 : " + resultCnt3);
    }

    @PostMapping("/findSearch")
    @ResponseBody
    public HashMap<String, Object> selectFind(@RequestBody InquiryDto inquiryDto) {
        HashMap<String, Object> mv = new HashMap<>();
        List<InquiryDto> list = inquiryService.findSearch(inquiryDto);
        mv.put("list", list);
        return mv;
    }

    @PostMapping("/isWriter")
    @ResponseBody
    public boolean isWriter(@RequestBody InquiryDto inquiryDto) {

        // 해당 유저가 쓴 글이 맞다면 true
        return inquiryService.isWriter(inquiryDto);
    }

    @PostMapping("/registRe")
    @ResponseBody
    private HashMap<String, Object> regist(@RequestBody InquiryReDto inquiryReDto){
        HashMap<String, Object> mv = new HashMap<>();

        int resultCnt = inquiryService.registRe(inquiryReDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);
        return mv;
    }

    @GetMapping("/findAllRe")
    @ResponseBody
    private HashMap<String, Object> findAllRe(){
        HashMap<String, Object> mv = new HashMap<>();
        List<InquiryReDto> list = inquiryService.findAllRe();

        mv.put("list", list);
        return mv;
    }


    @PostMapping("/modifyRe")
    @ResponseBody
    public void modifyRe(@RequestBody InquiryReDto inquiryReDto) {
        int resultCnt2 = inquiryService.modifyRe(inquiryReDto);
        System.out.println("문의 내역 답변 수정 완료 여부 : " + resultCnt2);
    }

    @PostMapping("/deleteRe")
    @ResponseBody
    public void delete(@RequestBody InquiryReDto inquiryReDto) {
        int resultCnt3 = inquiryService.deleteRe(inquiryReDto);
        System.out.println("문의 내역 답변 삭제 완료 여부 : " + resultCnt3);
    }

    @PostMapping("/findSearchRe")
    @ResponseBody
    public HashMap<String, Object> selectFind(@RequestBody InquiryReDto inquiryReDto) {
        HashMap<String, Object> mv = new HashMap<>();
        List<InquiryReDto> list = inquiryService.findSearchRe(inquiryReDto);
        mv.put("list", list);
        return mv;
    }
}
