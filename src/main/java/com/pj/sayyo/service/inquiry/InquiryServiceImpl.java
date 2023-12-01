package com.pj.sayyo.service.inquiry;

import com.pj.sayyo.model.fulfillment.mapper.FulfillmentMapper;
import com.pj.sayyo.model.inquiry.dto.InquiryDto;
import com.pj.sayyo.model.inquiry.dto.InquiryReDto;
import com.pj.sayyo.model.inquiry.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {
    @Autowired
    private InquiryMapper inquiryMapper;


    @Override
    public int regist(InquiryDto inquiryDto) {
        return inquiryMapper.regist(inquiryDto);
    }

    @Override
    public List<InquiryDto> findAll() {
        return inquiryMapper.findAll();
    }

    @Override
    public int modify(InquiryDto inquiryDto) {
        return inquiryMapper.modify(inquiryDto);
    }

    @Override
    public int delete(InquiryDto inquiryDto) {
        return inquiryMapper.delete(inquiryDto);
    }

    @Override
    public List<InquiryDto> findSearch(InquiryDto inquiryDto) {
        return inquiryMapper.findSearch(inquiryDto);
    }

    @Override
    public int registRe(InquiryReDto inquiryReDto) {
        return inquiryMapper.registRe(inquiryReDto);
    }

    @Override
    public List<InquiryReDto> findAllRe() {
        return inquiryMapper.findAllRe();
    }

    @Override
    public int modifyRe(InquiryReDto inquiryReDto) {
        return inquiryMapper.modifyRe(inquiryReDto);
    }

    @Override
    public int deleteRe(InquiryReDto inquiryReDto) {
        return inquiryMapper.deleteRe(inquiryReDto);
    }

    @Override
    public List<InquiryReDto> findSearchRe(InquiryReDto inquiryReDto) {
        return inquiryMapper.findSearchRe(inquiryReDto);
    }
}
