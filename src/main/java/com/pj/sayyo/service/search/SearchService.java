package com.pj.sayyo.service.search;

import com.pj.sayyo.model.search.dto.SearchDto;
import org.apache.ibatis.javassist.compiler.ast.Keyword;

import java.util.List;

public interface SearchService {
    int saveKeyword(SearchDto searchDto);
    List<SearchDto> getPopularKeywords();
}