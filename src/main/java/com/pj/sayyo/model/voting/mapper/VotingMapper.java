package com.pj.sayyo.model.voting.mapper;

import com.pj.sayyo.model.voting.dto.VotedDto;
import com.pj.sayyo.model.voting.dto.VotedataDto;
import com.pj.sayyo.model.voting.dto.VotingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VotingMapper {
    int regist(VotingDto votingDto);
    int delete(VotingDto votingDto);
    List<VotingDto> findAll();
    int candidates(VotedDto votedDto);
    int voteScore(VotingDto votingDto);
    int voted(VotedDto votedDto);
    int findVoted(VotedDto votedDto);

    // votedata
    int votedata(VotedataDto votedataDto);
    int getGender(VotedataDto votedataDto);
    int getRegion(VotedataDto votedataDto);
    int getAge(VotedataDto votedataDto);

}