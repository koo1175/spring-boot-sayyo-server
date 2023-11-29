package com.pj.sayyo.controller.mail;

import com.pj.sayyo.model.mail.dto.MailDto;
import com.pj.sayyo.service.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    @ResponseBody
    @PostMapping("/mail")
    public void sendMail(@RequestBody MailDto mailDto) {
        // 입력된 메일을 콘솔에 출력
        System.out.println("Received mail: " + mailDto.toString());
        mailService.sendMail(mailDto);
    }

    @ResponseBody
    @PostMapping("/mail/verify")
    public String verifyCode(@RequestBody MailDto mailDto) {
        String mv = mailService.verifyCode(mailDto).getAuthCode();
        System.out.println("야임마!: " + mv);
        return mv;
    }
}