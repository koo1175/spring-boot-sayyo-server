package com.pj.sayyo.service.inquiry;

import com.pj.sayyo.model.fulfillment.dto.FulfillmentDto;
import com.pj.sayyo.model.inquiry.dto.InquiryDto;
import com.pj.sayyo.model.inquiry.dto.InquiryReDto;

import java.util.List;

public interface InquiryService {
    int regist(InquiryDto inquiryDto);
    List<InquiryDto> findAll();
    int modify(InquiryDto inquiryDto);
    int delete(InquiryDto inquiryDto);
    List<InquiryDto> findSearch(InquiryDto inquiryDto);

    int registRe(InquiryReDto inquiryReDto);
    List<InquiryReDto> findAllRe();
    int modifyRe(InquiryReDto inquiryReDto);
    int deleteRe(InquiryReDto inquiryReDto);
    List<InquiryReDto> findSearchRe(InquiryReDto inquiryReDto);
}
