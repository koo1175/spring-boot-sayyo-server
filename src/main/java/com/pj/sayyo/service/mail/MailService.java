package com.pj.sayyo.service.mail;

import com.pj.sayyo.model.mail.dto.MailDto;
import com.pj.sayyo.model.mail.mapper.MailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class MailService {

    private final JavaMailSender javaMailSender;
    @Autowired
    private MailMapper mailMapper;
    private static final String senderEmail= "sayyo2023@gmail.com";
    private static int number;

    public MailService() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost("smtp.gmail.com"); // 호스트 정보 설정
        mailSenderImpl.setPort(587); // 포트 정보 설정
        mailSenderImpl.setUsername("sayyo2023@gmail.com"); // 계정 이름 설정
        mailSenderImpl.setPassword("qygs jipq naqi nhih"); // 계정 비밀번호 설정

        this.javaMailSender = mailSenderImpl;
        Properties props = mailSenderImpl.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true"); // TLS 활성화
    }

    public static void createNumber(){
        number = (int)(Math.random() * (90000)) + 100000;
    }

    public MailDto verifyCode(MailDto mailDto) {
        return mailMapper.getAuthCode(mailDto);
    }

    public MimeMessage sendMail(MailDto mailDto) {
        createNumber();
        mailDto.setAuthCode(String.valueOf(number));
        MimeMessage message = javaMailSender.createMimeMessage();
        mailMapper.insertMail(mailDto);
        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mailDto.getEmail());
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

}

