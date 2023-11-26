package com.pj.sayyo.controller.search;

import com.pj.sayyo.model.member.dto.MemberDto;
import com.pj.sayyo.model.search.dto.SearchDto;
import com.pj.sayyo.service.search.SearchService;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

        @Autowired
        private SearchService searchService;

        @PostMapping("/regist")
        @ResponseBody
        public HashMap<String, Object> saveKeyword(@RequestBody SearchDto searchDto) {
            HashMap<String, Object> result = new HashMap<>();
            searchService.saveKeyword(searchDto);
            result.put("result", "success");
            return result;
        }

        @GetMapping("/popular")
        @ResponseBody
        public HashMap<String, Object> getPopularKeywords() {
            HashMap<String, Object> mv = new HashMap<>();
            List<SearchDto> list = searchService.getPopularKeywords();
            mv.put("list", list);
            return mv;
        }

}
