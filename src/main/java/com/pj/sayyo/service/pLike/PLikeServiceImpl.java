package com.pj.sayyo.service.pLike;

import com.pj.sayyo.model.member.dto.MemberDto;
import com.pj.sayyo.model.pLike.dto.PLikeDto;
import com.pj.sayyo.model.pLike.mapper.PLikeMapper;
import com.pj.sayyo.model.politician.dto.PoliticianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PLikeServiceImpl implements PLikeService{
    @Autowired
    private PLikeMapper pLikeMapper;

    @Override
    public int like(PLikeDto pLikeDto) {
        return pLikeMapper.like(pLikeDto);
    }
    @Override
    public int polLike(PoliticianDto politicianDto) {
        return pLikeMapper.polLike(politicianDto);
    }

    @Override
    public int dislike(PLikeDto pLikeDto) {
        return pLikeMapper.dislike(pLikeDto);
    }

    @Override
    public int polDislike(PoliticianDto politicianDto) {
        return pLikeMapper.polDislike(politicianDto);
    }

    @Override
    public int cancelLike(PLikeDto pLikeDto) {
        return pLikeMapper.cancelLike(pLikeDto);
    }

    @Override
    public int polCancelLike(PoliticianDto politicianDto) {
        return pLikeMapper.polCancelLike(politicianDto);
    }

    @Override
    public int polCancelDislike(PoliticianDto politicianDto) {
        return pLikeMapper.polCancelDislike(politicianDto);
    }


    @Override
    public List<PLikeDto> findAll() {
        return pLikeMapper.findAll();
    }

    @Override
    public int modify(PLikeDto pLikeDto) {
        return pLikeMapper.modify(pLikeDto);
    }


    @Override
    public int findLike(PLikeDto pLikeDto) {
        return pLikeMapper.findLike(pLikeDto);
    }

    @Override
    public int deleteLike(PLikeDto pLikeDto){ return pLikeMapper.deleteLike(pLikeDto);}

    @Override
    public boolean exist(PLikeDto pLikeDto){
        return pLikeMapper.exist(pLikeDto);
    }
    @Override
    public PLikeDto findState(PLikeDto pLikeDto){ return pLikeMapper.findState(pLikeDto);}
}
