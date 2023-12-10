package com.pj.sayyo.service.pLike;

import com.pj.sayyo.model.pLike.dto.PLikeDto;
import com.pj.sayyo.model.pLike.mapper.PLikeMapper;
import com.pj.sayyo.model.politician.dto.PoliticianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PLikeService {
    int like(PLikeDto pLikeDto);
    int polLike(PoliticianDto politicianDto);
    int dislike(PLikeDto pLikeDto);
    int polDislike(PoliticianDto politicianDto);
    int cancelLike(PLikeDto pLikeDto);
    int polCancelLike(PoliticianDto politicianDto);
    int deleteLike(PLikeDto pLikeDto);
    int polCancelDislike(PoliticianDto politicianDto);
    List<PLikeDto> findAll();
    int modify(PLikeDto pLikeDto);
    int findLike(PLikeDto pLikeDto);
    boolean exist(PLikeDto pLikeDto);
    PLikeDto findState(PLikeDto pLikeDto);
}
