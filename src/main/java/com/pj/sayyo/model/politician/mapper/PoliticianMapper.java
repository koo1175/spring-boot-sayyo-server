package com.pj.sayyo.model.politician.mapper;

import com.pj.sayyo.model.politician.dto.PoliticianDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PoliticianMapper {
    int regist(PoliticianDto politicianDto);
    List<PoliticianDto> findAll();
    int modify(PoliticianDto politicianDto);
    int delete(PoliticianDto politicianDto);
    int deleteLike(PoliticianDto politicianDto);
    int likes(PoliticianDto politicianDto);
    int dislike(PoliticianDto politicianDto);
    PoliticianDto findSearch(PoliticianDto politicianDto);
}
