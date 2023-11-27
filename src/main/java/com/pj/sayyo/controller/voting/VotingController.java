package com.pj.sayyo.controller.voting;

import com.pj.sayyo.model.member.dto.MemberDto;
import com.pj.sayyo.model.voting.dto.VotedDto;
import com.pj.sayyo.model.voting.dto.VotedataDto;
import com.pj.sayyo.model.voting.dto.VotingDto;
import com.pj.sayyo.service.member.MemberService;
import com.pj.sayyo.service.voting.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;
import java.time.LocalDate;

@Controller
@RequestMapping("/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/regist")
    @ResponseBody
    private HashMap<String, Object> regist(@RequestBody VotingDto votingDto){
        HashMap<String, Object> mv = new HashMap<>();

        int resultCnt = votingService.regist(votingDto);
        mv.put("result", resultCnt);
        System.out.println(resultCnt);

        return mv;
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody VotingDto votingDto) {
        int resultCnt3 = votingService.delete(votingDto);
        System.out.println("삭제 완료 여부 : " + resultCnt3);

    }


    //전체 조회 GET
    @GetMapping("/findAll")
    @ResponseBody
    private HashMap<String, Object> findAll(){
        HashMap<String, Object> mv = new HashMap<>();
        List<VotingDto> list = votingService.findAll();
        mv.put("list", list);
        return mv;
    }


    //투표수 +1 /findVoted POST요청 했을 때 0이면 +1하면 안되고 1이면 +1
    @PostMapping("/voteScore")
    @ResponseBody
    public void increaseScore(@RequestBody VotingDto votingDto) {
        votingService.voteScore(votingDto);
    }


    // 투표가 정상적으로 됐을 경우 1 반환
    @PostMapping("/voted")
    @ResponseBody
    private Integer voted(@RequestBody VotedDto votedDto){
        HashMap<String, Object> mv = new HashMap<>();
        int exist = votingService.findVoted(votedDto);
        int resultCnt = 0;
        System.out.println("이미 존재하는지 안하는지 ?"+exist);
        // 존재 안할 때 0 반환 -> 등록
        if(exist==0){
            resultCnt = votingService.voted(votedDto);

            // 임의로 member를 생성해둔뒤
            MemberDto mem = new MemberDto();
            mem.setId(votedDto.getMemberId());
            // memberDto에 if를 넣어두고 해당 id의 회원 정보를 가져온다
            mem = memberService.findSearchById(mem);
            System.out.println("투표 시 가져와진 멤버의 정보: "+mem.toString());

            VotedataDto data = new VotedataDto();

            // 주민등록번호
            String registNum = mem.getRegistNum();

            // 몇십대인지
            int thisYear = LocalDate.now().getYear();
            int birthYear = Integer.parseInt(registNum.substring(0,2));
            int genderDigit = Character.getNumericValue(registNum.charAt(6));
            System.out.println("회원의 나이 : "+(thisYear - (2000 + birthYear) + 1));
            if(genderDigit < 3){
                data.setAge((thisYear - (1900 + birthYear) + 1) / 10 * 10);
            }else{
                System.out.println("회원의 연령대 : "+(thisYear - (2000 + birthYear) + 1) / 10 * 10);
                data.setAge((thisYear - (2000 + birthYear) + 1) / 10 * 10);
            }

            if(genderDigit % 2 == 0){
                data.setGender("여자");
            }else{
                data.setGender("남자");
            }
            Pattern pattern = Pattern.compile("(\\S+)시");
            Matcher matcher = pattern.matcher(mem.getAddress());
            if(matcher.find()){
                data.setRegion(matcher.group(1));
            }else{
                data.setRegion("알 수 없음");
            }

            // 투표자들의 정보 수집
            data.setMemberId(votedDto.getMemberId());
            data.setTitle(votedDto.getTitle());
            data.setNum(votedDto.getNum());
            votingService.votedata(data);

            // 후보자들의 점수 갱신
            VotingDto votingDto = new VotingDto();
            votingDto.setTitle(votedDto.getTitle());
            votingDto.setNum(votedDto.getNum());
            votingService.voteScore(votingDto);
        }else{

        }

        return resultCnt;
    }

    //투표한사람 리스트 POST 0이면 투표 안함 1이면 투표 함
    @PostMapping("/findVoted")
    @ResponseBody
    private Integer votedCount(@RequestBody VotedDto votedDto) {
        HashMap<String, Object> mv = new HashMap<>();
        int count = votingService.findVoted(votedDto);
        mv.put("count", count);
        return count;
    }

    @PostMapping("/candidates")
    @ResponseBody
    private HashMap<String, Object> candidates(@RequestBody VotedDto votedDto) {
        HashMap<String, Object> mv = new HashMap<>();
        int candidate = votingService.candidates(votedDto);
        System.out.println("candidate요청 결과 : " + candidate);
        mv.put("candidates", candidate);
        return mv;
    }

    @GetMapping("/getGender")
    @ResponseBody
    private HashMap<String, Object> getGender(){

        HashMap<String, Object> mv = new HashMap<>();
        String[] genders = {"남자", "여자"}; // 성별 배열
        int result2 = 0;

        for (String gender : genders) {
            VotedataDto votedataDto = new VotedataDto();
            votedataDto.setGender(gender); // 성별 설정
            int[] nums = {1, 2, 3, 4};
            for(int num: nums){
                votedataDto.setNum(num);
                result2 = votingService.getGenderWho(votedataDto);
                mv.put(gender+","+num, result2); // 지역 후보번호 를 키로, 결과를 값으로 저장
            }
            int result = votingService.getGender(votedataDto);
            System.out.println(gender + "의 getGender 요청 결과 : " + result);
            mv.put(gender, result); // 성별을 키로, 결과를 값으로 저장
        }
        return mv;
    }

    @GetMapping("/getAge")
    @ResponseBody
    private HashMap<String, Object> getAge(){

        HashMap<String, Object> mv = new HashMap<>();
        int[] ages = {10, 20, 30, 40, 50, 60, 70, 80}; // 성별 배열
        int result2 = 0;

        for (int age : ages) {
            VotedataDto votedataDto = new VotedataDto();
            votedataDto.setAge(age); // 나이 설정
            int[] nums = {1, 2, 3, 4};
            for(int num: nums){
                votedataDto.setNum(num);
                result2 = votingService.getAgeWho(votedataDto);
                mv.put(age+","+num, result2); // 지역 후보번호 를 키로, 결과를 값으로 저장
            }
            int result = votingService.getAge(votedataDto);
            System.out.println(age + "의 getAge 요청 결과 : " + result);
            mv.put(String.valueOf(age), result); // 나이대를 키로, 결과를 값으로 저장
        }
        return mv;
    }

    @GetMapping("/getRegion")
    @ResponseBody
    private HashMap<String, Object> getRegion(){

        HashMap<String, Object> mv = new HashMap<>();
        String[] regions = {"서울", "수원", "의정부", "남양주", "김포", "양주", "안양", "동두천", "포천", "광주", "여주", "안성", "용인", "평택", "화성",
                            "오산", "군포", "의왕", "안산", "시흥", "부천", "성남", "과천", "광명", "하남", "구리", "고양", "파주", "이천"}; // 지역 배열
        int result2 = 0;
        for (String region : regions) {

            VotedataDto votedataDto = new VotedataDto();
            votedataDto.setRegion(region); // 지역 설정
            int[] nums = {1, 2, 3, 4};
            for(int num: nums){
                votedataDto.setNum(num);
                result2 = votingService.getRegionWho(votedataDto);
                mv.put(region+","+num, result2); // 지역 후보번호 를 키로, 결과를 값으로 저장
            }
            int result = votingService.getRegion(votedataDto);
            System.out.println(region + "의 getRegion 요청 결과 : " + result);
        }
        return mv;
    }



}
