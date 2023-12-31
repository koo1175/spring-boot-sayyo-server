package com.pj.sayyo.controller.laws;


import com.pj.sayyo.model.laws.dto.LawsDto;
import com.pj.sayyo.service.laws.LawsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/laws")
public class LawsController {

    @Autowired
    private LawsService lawsService;

    @GetMapping("/findAll")
    @ResponseBody
    private HashMap<String, Object> findAll(){
        HashMap<String, Object> mv = new HashMap<>();
        List<LawsDto> list = lawsService.findAll();

        mv.put("laws", list);
        return mv;
    }

    @GetMapping("/findNew")
    @ResponseBody
    private HashMap<String, Object> findNew(){
        HashMap<String, Object> mv = new HashMap<>();
        List<LawsDto> list = lawsService.findAll();

        mv.put("laws", list);
        return mv;
    }

    @GetMapping("/findNewEight")
    @ResponseBody
    private HashMap<String, Object> findNewEight(){
        HashMap<String, Object> mv = new HashMap<>();
        List<LawsDto> list = lawsService.findNewEight();

        mv.put("laws", list);
        return mv;
    }

    @GetMapping("/findPol")
    @ResponseBody
    private HashMap<String, Object> findPol(){
        HashMap<String, Object> mv = new HashMap<>();
        List<LawsDto> list = lawsService.findAll();

        mv.put("laws", list);
        return mv;
    }
}
