package com.pj.sayyo.controller.mail;

import com.pj.sayyo.model.mail.dto.MailDto;
import com.pj.sayyo.service.mail.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MailController {

    @Autowired
    private MailServiceImpl mailService;

    @ResponseBody
    @PostMapping("/mail")
    public void sendMail(@RequestBody MailDto mailDto) {
        mailService.sendMail(mailDto);
    }

    @ResponseBody
    @PostMapping("/mail/verify")
    public String verifyCode(@RequestBody MailDto mailDto) {
        String mv = mailService.verifyCode(mailDto).getAuthCode();
        return mv;
    }
}