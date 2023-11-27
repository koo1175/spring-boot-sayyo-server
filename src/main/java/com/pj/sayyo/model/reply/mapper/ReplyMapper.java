package com.pj.sayyo.model.reply.mapper;

import com.pj.sayyo.model.reply.dto.ReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int regist(ReplyDto replyDto);
    List<ReplyDto> findAll(ReplyDto replyDto);
    int modify(ReplyDto replyDto);
    int delete(ReplyDto replyDto);

}
