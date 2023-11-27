package com.pj.sayyo.service.voting;

import com.pj.sayyo.model.voting.dto.VotedDto;
import com.pj.sayyo.model.voting.dto.VotedataDto;
import com.pj.sayyo.model.voting.dto.VotingDto;
import com.pj.sayyo.model.voting.mapper.VotingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingServiceImpl implements VotingService{

    @Autowired
    private VotingMapper votingMapper;
    @Override
    public int regist(VotingDto votingDto) {
        return votingMapper.regist(votingDto);
    }

    @Override
    public int delete(VotingDto votingDto) {
        return votingMapper.delete(votingDto);
    }

    @Override
    public List<VotingDto> findAll() {
        return votingMapper.findAll();
    }
    @Override
    public int candidates(VotedDto votedDto) {
        return votingMapper.candidates(votedDto);
    }

    @Override
    public int voteScore(VotingDto votingDto) {
        return votingMapper.voteScore(votingDto);
    }

    @Override
    public int voted(VotedDto votedDto) {
        return votingMapper.voted(votedDto);
    }

    @Override
    public int findVoted(VotedDto votedDto) {
        return votingMapper.findVoted(votedDto);
    }

    // votedata
    @Override
    public int votedata(VotedataDto votedataDto){
        return votingMapper.votedata(votedataDto);
    }
    @Override
    public int getRegion(VotedataDto votedataDto){
        return votingMapper.getRegion(votedataDto);
    }
    @Override
    public int getGender(VotedataDto votedataDto){
        return votingMapper.getGender(votedataDto);
    }
    @Override
    public int getAge(VotedataDto votedataDto){
        return votingMapper.getAge(votedataDto);
    }
    @Override
    public int getRegionWho(VotedataDto votedataDto){
        return votingMapper.getRegionWho(votedataDto);
    }
    @Override
    public int getGenderWho(VotedataDto votedataDto){
        return votingMapper.getGenderWho(votedataDto);
    }
    @Override
    public int getAgeWho(VotedataDto votedataDto){
        return votingMapper.getAgeWho(votedataDto);
    }
}
