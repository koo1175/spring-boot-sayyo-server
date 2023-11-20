package com.pj.sayyo.model.chat.mapper;

import com.pj.sayyo.model.chat.dto.ChatDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
    ChatDto send(ChatDto chatDto);
}
