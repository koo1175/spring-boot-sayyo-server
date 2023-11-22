package com.pj.sayyo.model.chat.mapper;

import com.pj.sayyo.model.chat.dto.ChatDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;

@Mapper
public interface ChatMapper {
    void send(ChatDto chatDto);

    int deleteOldest();
    int count(ChatDto chatDto);
    LinkedList<ChatDto> allChat();
}
