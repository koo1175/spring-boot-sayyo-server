package com.pj.sayyo.service.mail;

import com.pj.sayyo.model.mail.dto.MailDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface MailService {
    void createNumber();
    MailDto verifyCode(MailDto mailDto);
    MimeMessage sendMail(MailDto mailDto) throws MessagingException;
}
