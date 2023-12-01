package com.pj.sayyo.controller.member;


import com.pj.sayyo.model.member.dto.MemberDto;
import com.pj.sayyo.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/regist")
    @ResponseBody
    private int regist(@RequestBody MemberDto memberDto){
        int resultCnt = 0;
        // 겹치는 아이디, 주민등록번호 없을 경우 가입 가능하도록
        if(memberService.isValidId(memberDto) && memberService.isValidRegist(memberDto)){
            resultCnt = memberService.regist(memberDto);
            System.out.println(resultCnt);
        }
        return resultCnt;
    }

    @PostMapping("/isValidId")
    @ResponseBody
    private boolean isValidId(@RequestBody MemberDto memberDto){
        return memberService.isValidId(memberDto);
    }

    @PostMapping("/isValidRegist")
    @ResponseBody
    private boolean isValidRegist(@RequestBody MemberDto memberDto){
        return memberService.isValidRegist(memberDto);
    }


    @PostMapping("/kakao")
    @ResponseBody
    private String kakao(@RequestBody MemberDto memberDto){
        HashMap<String, Object> mv = new HashMap<>();

        if(memberDto.getNickname().equals("꽥꽥이")){
            return "다시 입력해주세요";
        }else if(memberDto.getPhone().equals("01012341234") || memberDto.getPhone().equals(" ")){
            return "다시 입력해주세요";
        }else if(memberDto.getAddress().equals("asd")){
            return "다시 입력해주세요";
        }else if(memberDto.getRegistNum().equals("1234561234567")){
            return "다시 입력해주세요";
        }
        int resultCnt = memberService.kakao(memberDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);

        return "로그인 성공 ( by kakao )";
    }


    @PostMapping("/login")
    @ResponseBody
    private MemberDto login(@RequestBody MemberDto memberDto){
        MemberDto m = memberService.login(memberDto);
        if(m == null){
            // 받아온 id와 pw에 해당하는 유저가 없을때
            System.out.println("로그인 실패");
            return m;
        }
        System.out.println(m.toString());
        System.out.println("로그인 성공");

        return m;
    }

    @GetMapping("/findAll")
    @ResponseBody
    private HashMap<String, Object> findAll(){
        HashMap<String, Object> mv = new HashMap<>();
        List<MemberDto> list = memberService.findAll();

        mv.put("list", list);
        return mv;
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody MemberDto memberDto) {
        int resultCnt2 = memberService.modify(memberDto);
        System.out.println("수정 완료 여부 : " + resultCnt2);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody MemberDto memberDto) {
        int resultCnt3 = memberService.delete(memberDto);
        System.out.println("삭제 완료 여부 : " + resultCnt3);

    }

    // 닉네임으로 요청
    @GetMapping("/findSearch")
    @ResponseBody
    public void selectFind(@RequestBody MemberDto memberDto) {
        HashMap<String, Object> mv = new HashMap<>();
        MemberDto member = memberService.findSearch(memberDto);

        mv.put("member", member);
        System.out.println(member.toString());
    }

    @PostMapping("/report")
    @ResponseBody
    public void report(@RequestBody MemberDto memberDto){
        int resultCnt4 = memberService.report(memberDto);
        System.out.println("신고 완료 여부 : " + resultCnt4);
    }
}
