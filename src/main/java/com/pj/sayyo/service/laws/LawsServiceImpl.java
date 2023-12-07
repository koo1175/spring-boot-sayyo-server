package com.pj.sayyo.service.laws;

import com.pj.sayyo.model.fulfillment.dto.FulfillmentDto;
import com.pj.sayyo.model.fulfillment.mapper.FulfillmentMapper;
import com.pj.sayyo.model.laws.dto.LawsDto;
import com.pj.sayyo.model.laws.mapper.LawsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawsServiceImpl implements LawsService {

    @Autowired
    private LawsMapper lawsMapper;

    @Override
    public List<LawsDto> findAll() {
        return lawsMapper.findAll();
    }
    @Override
    public List<LawsDto> findNew() {
        return lawsMapper.findNew();
    }
    @Override
    public List<LawsDto> findNewEight(){
        return lawsMapper.findNewEight();
    }
    @Override
    public List<LawsDto> findPol() {
        return lawsMapper.findPol();
    }

}
