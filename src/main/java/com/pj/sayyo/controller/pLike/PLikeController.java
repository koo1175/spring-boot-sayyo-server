package com.pj.sayyo.controller.pLike;

import com.pj.sayyo.model.pLike.dto.PLikeDto;
import com.pj.sayyo.model.politician.dto.PoliticianDto;
import com.pj.sayyo.service.pLike.PLikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/plike")
public class PLikeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PLikeService pLikeService;

    @PostMapping("/state")
    @ResponseBody
    private String state(@RequestBody PLikeDto pLikeDto){
        System.out.println("입력받은 값 : "+pLikeDto.toString());
        
        // 좋아요 기록이 있나?
        if(pLikeService.exist(pLikeDto)){
            System.out.println("기록 존재");
            char emp = pLikeService.findState(pLikeDto).getLikeState();
            if(emp=='1'){
                System.out.println("좋아요가 눌려있음");
                // 좋아요가 눌려있을 때
                return "like";
            }else if(emp=='2'){
                System.out.println("싫어요가 눌려있음");
                return "dislike";
            }else{
                return "nothing";
            }
        }else{
            System.out.println("기록 존재하지 않음");
            return "nothing";
        }

    }

    // 좋아요 눌렀을 때
    @PostMapping("/like")
    @ResponseBody
    private HashMap<String, Object> like(@RequestBody PLikeDto pLikeDto){
        HashMap<String, Object> mv = new HashMap<>();
        int findLike = pLikeService.findLike(pLikeDto);
        PLikeDto findState = pLikeService.findState(pLikeDto);

        // 이미 like가 존재할때
        if(findLike==1){
            pLikeService.deleteLike(pLikeDto);
            // 좋아요가 이미 눌려있을 때 취소하자
            if(findState.getLikeState().toString().equals("1")){
                PoliticianDto p = new PoliticianDto();
                p.setRegion(pLikeDto.getRegion());
                pLikeService.polCancelLike(p);
                return mv;
            }
        }
        int resultCnt = pLikeService.like(pLikeDto);
        PoliticianDto p = new PoliticianDto();
        p.setRegion(pLikeDto.getRegion());
        int resultCnt2 = pLikeService.polLike(p);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);
        System.out.println(resultCnt2);

        return mv;
    }
    
    // 싫어요 눌렀을 때
    @PostMapping("/dislike")
    @ResponseBody
    private HashMap<String, Object> disLike(@RequestBody PLikeDto pLikeDto){
        HashMap<String, Object> mv = new HashMap<>();

        System.out.println("dislike 작동");
        PLikeDto findState = pLikeService.findState(pLikeDto);
        int findLike = pLikeService.findLike(pLikeDto);
        System.out.println(pLikeDto.toString());
        System.out.println(findLike);
        // 이미 like 테이블이 존재할때
        if(findLike==1){
            System.out.println("이미 like 테이블이 존재함을 인식");
            // 싫어요가 이미 눌려있을 때
            if(findState.getLikeState().toString().equals("2")){
                System.out.println("싫어요가 이미 눌려있다 cancelLike로 가자");
                return cancelLike(pLikeDto);
            }
        }
        // 테이블이 존재하지 않을땐 바로 여기로 넘어오게됨
        int resultCnt = pLikeService.dislike(pLikeDto);
        PoliticianDto p = new PoliticianDto();
        p.setRegion(pLikeDto.getRegion());
        int resultCnt2 = pLikeService.polDislike(p);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);
        System.out.println(resultCnt2);

        return mv;
    }

    @PostMapping("/cancelLike")
    @ResponseBody
    private HashMap<String, Object> cancelLike(@RequestBody PLikeDto pLikeDto){
        HashMap<String, Object> mv = new HashMap<>();
        int resultCnt;
        int resultCnt2;
        System.out.println("cancelLike 작동");

        int findLike = pLikeService.findLike(pLikeDto);
        PLikeDto findState = pLikeService.findState(pLikeDto);
        // 이미 like가 존재할때 상태를 0으로 바꿔주도록 했지만
        // 그냥 삭제해버리기로 했다 깔끔하게
        if(findLike==1){
            System.out.println("이미 like가 존재함을 인식");
            resultCnt = pLikeService.deleteLike(pLikeDto);
            System.out.println("resultCnt : " + resultCnt);
            mv.put("result", resultCnt);
            // 좋아요가 눌려있을 경우 시장님 좋아요 취소해주자
            if(findState.getLikeState().toString().equals("1")){
                System.out.println("이미 좋아요가 눌려있음을 인식");
                PoliticianDto p = new PoliticianDto();
                p.setRegion(pLikeDto.getRegion());
                resultCnt2 = pLikeService.polCancelLike(p);
                System.out.println("resultCnt2 : " + resultCnt2);
            // 싫어요가 눌려있을 경우 시장님 싫어요 취소해주자
            }else if(findState.getLikeState().toString().equals("2")) {
                System.out.println("이미 싫어요가 눌려있음을 인식");
                PoliticianDto p = new PoliticianDto();
                p.setRegion(pLikeDto.getRegion());
                resultCnt2 = pLikeService.polCancelDislike(p);
                System.out.println("resultCnt2 : " + resultCnt2);
            }
        }
        return mv;
    }


}
