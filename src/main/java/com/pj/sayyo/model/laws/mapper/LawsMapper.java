package com.pj.sayyo.model.laws.mapper;

import com.pj.sayyo.model.laws.dto.LawsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LawsMapper {
    int regist(LawsDto lawsDto);
    List<LawsDto> findAll();
    List<LawsDto> findNew();
    List<LawsDto> findPol();
    int modify(LawsDto lawsDto);
    int delete(LawsDto lawsDto);
    List<LawsDto> findSearch(LawsDto lawsDto);
}
