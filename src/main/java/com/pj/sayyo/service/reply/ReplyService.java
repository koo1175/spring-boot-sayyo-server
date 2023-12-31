package com.pj.sayyo.service.reply;

import com.pj.sayyo.model.reply.dto.ReplyDto;

import java.util.List;

public interface ReplyService {
    int regist(ReplyDto replyDto);
    List<ReplyDto> findAll(ReplyDto replyDto);
    int modify(ReplyDto replyDto);
    int delete(ReplyDto replyDto);

    boolean isWriter(ReplyDto replyDto);

}
