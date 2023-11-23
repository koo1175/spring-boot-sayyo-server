package com.pj.sayyo.controller.memboard;

import com.pj.sayyo.model.memBoard.dto.MemBoardDto;
import com.pj.sayyo.service.memBoard.MemBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/memBoard")
public class MemBoardController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemBoardService memBoardService;

    @PostMapping("/regist")
    @ResponseBody
    private HashMap<String, Object> regist(@RequestBody MemBoardDto memboardDto){
        HashMap<String, Object> mv = new HashMap<>();

        int resultCnt = memBoardService.regist(memboardDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);

        return mv;
    }

    @GetMapping("/findAll")
    @ResponseBody
    private HashMap<String, Object> findAll(){
        HashMap<String, Object> mv = new HashMap<>();
        List<MemBoardDto> list = memBoardService.findAll();

        mv.put("list", list);
        return mv;
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody MemBoardDto memboardDto) {
        int resultCnt2 = memBoardService.modify(memboardDto);
        System.out.println("수정 완료 여부 : " + resultCnt2);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody MemBoardDto memboardDto) {
        int resultCnt3 = memBoardService.delete(memboardDto);
        System.out.println("삭제 완료 여부 : " + resultCnt3);

    }

    @GetMapping("/findSearch")
    @ResponseBody
    public void selectFind(@RequestBody MemBoardDto memboardDto) {
        HashMap<String, Object> mv = new HashMap<>();
        List<MemBoardDto> list = memBoardService.findSearch(memboardDto);

        mv.put("list", list);
    }

}
