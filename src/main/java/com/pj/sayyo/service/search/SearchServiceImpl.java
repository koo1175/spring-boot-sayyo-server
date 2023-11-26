package com.pj.sayyo.service.search;

import com.pj.sayyo.model.search.dto.SearchDto;
import com.pj.sayyo.model.search.mapper.SearchMapper;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private SearchMapper searchMapper;
    @Override
    public int saveKeyword(SearchDto searchDto) {
        int result;
        searchMapper.insertKeyword(searchDto);
        result = 1; // insert 성공
        return result;
    }

    @Override
    public List<SearchDto> getPopularKeywords() {
        return searchMapper.getPopularKeywords();
    }
}
