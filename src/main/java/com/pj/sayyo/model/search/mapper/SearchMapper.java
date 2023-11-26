package com.pj.sayyo.model.search.mapper;

import com.pj.sayyo.model.search.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import java.util.List;

@Mapper
public interface SearchMapper {
    void insertKeyword(SearchDto searchDto);
    List<SearchDto> getPopularKeywords();
}
