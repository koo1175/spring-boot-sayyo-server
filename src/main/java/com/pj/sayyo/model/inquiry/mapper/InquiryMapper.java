package com.pj.sayyo.model.inquiry.mapper;

import com.pj.sayyo.model.inquiry.dto.InquiryDto;
import com.pj.sayyo.model.inquiry.dto.InquiryReDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryMapper {
    // 문의내역
    int regist(InquiryDto inquiryDto);
    List<InquiryDto> findAll();
    int modify(InquiryDto inquiryDto);
    int delete(InquiryDto inquiryDto);
    List<InquiryDto> findSearch(InquiryDto inquiryDto);
    boolean isWriter(InquiryDto inquiryDto);


    // 문의내역 답변
    int registRe(InquiryReDto inquiryReDto);
    List<InquiryReDto> findAllRe();
    int modifyRe(InquiryReDto inquiryReDto);
    int deleteRe(InquiryReDto inquiryReDto);
    List<InquiryReDto> findSearchRe(InquiryReDto inquiryReDto);
}
