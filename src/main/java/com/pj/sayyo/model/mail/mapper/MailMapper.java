package com.pj.sayyo.model.mail.mapper;

import com.pj.sayyo.model.mail.dto.MailDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MailMapper {

    MailDto getAuthCode(MailDto mailDto);
    void insertMail(MailDto mailDto);
}