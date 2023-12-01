package com.pj.sayyo.service.mail;

import com.pj.sayyo.model.mail.dto.MailDto;
import com.pj.sayyo.model.mail.mapper.MailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;


@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;
    @Autowired
    private MailMapper mailMapper;
    private static final String senderEmail= "sayyo2023@gmail.com";
    private static int number;

    public MailServiceImpl() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost("smtp.gmail.com"); // 호스트 정보 설정
        mailSenderImpl.setPort(587); // 포트 정보 설정
        mailSenderImpl.setUsername("sayyo2023@gmail.com"); // 계정 이름 설정
        mailSenderImpl.setPassword("qygs jipq naqi nhih"); // 계정 비밀번호 설정

        this.javaMailSender = mailSenderImpl;
        Properties props = mailSenderImpl.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true"); // TLS 활성화
    }

    public void createNumber(){
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
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8"); // 인코딩을 UTF-8로 설정합니다.
            helper.setFrom(senderEmail);
            helper.setTo(mailDto.getEmail());
            helper.setSubject("세상이 요지경 회원가입 이메일 인증");

            String body = "";
            body += "<div style='margin:100px;'>";
            body += "<h1> 안녕하세요</h1>";
            body += "<h1> 통합 정치 정보 포탈 세상이 요지경 입니다.</h1>";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            body += "</div>";
            helper.setText(body, true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }
}
