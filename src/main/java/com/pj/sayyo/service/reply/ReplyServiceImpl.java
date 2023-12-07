package com.pj.sayyo.service.reply;

import com.pj.sayyo.model.reply.dto.ReplyDto;
import com.pj.sayyo.model.reply.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int regist(ReplyDto replyDto) {
        return replyMapper.regist(replyDto);
    }

    @Override
    public List<ReplyDto> findAll(ReplyDto replyDto) {
        return replyMapper.findAll(replyDto);
    }

    @Override
    public int modify(ReplyDto replyDto) {
        return replyMapper.modify(replyDto);
    }

    @Override
    public int delete(ReplyDto replyDto) {
        return replyMapper.delete(replyDto);
    }

    @Override
    public boolean isWriter(ReplyDto replyDto){
        return replyMapper.isWriter(replyDto);
    }
}
