package com.pj.sayyo.model.pLike.mapper;

import com.pj.sayyo.model.pLike.dto.PLikeDto;
import com.pj.sayyo.model.politician.dto.PoliticianDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PLikeMapper {
    int like(PLikeDto pLikeDto);
    int polLike(PoliticianDto politicianDto);
    int dislike(PLikeDto pLikeDto);
    int polDislike(PoliticianDto politicianDto);
    int cancelLike(PLikeDto pLikeDto);
    int polCancelLike(PoliticianDto politicianDto);
    int polCancelDislike(PoliticianDto politicianDto);
    List<PLikeDto> findAll();
    int modify(PLikeDto pLikeDto);
    int findLike(PLikeDto pLikeDto);
    int deleteLike(PLikeDto pLikeDto);
    boolean exist(PLikeDto pLikeDto);
    PLikeDto findState(PLikeDto pLikeDto);
}