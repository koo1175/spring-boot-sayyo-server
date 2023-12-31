package com.pj.sayyo.service.fulfillment;

import com.pj.sayyo.model.fulfillment.dto.FulfillmentDto;

import java.math.BigDecimal;
import java.util.List;

public interface FulfillmentService {
    int regist(FulfillmentDto fulfullmentDto);
    List<FulfillmentDto> findAll();
    int modify(FulfillmentDto fulfullmentDto);
    int delete(FulfillmentDto fulfullmentDto);
    List<FulfillmentDto> findSearch(FulfillmentDto fulfullmentDto);
    BigDecimal returnF(FulfillmentDto fulfillmentDto);
    int setFulfillment(FulfillmentDto fulfillmentDto);
    List<FulfillmentDto> topFive();
}
