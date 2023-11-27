package com.pj.sayyo.service.voting;

import java.util.List;

import com.pj.sayyo.model.voting.dto.VotedDto;
import com.pj.sayyo.model.voting.dto.VotedataDto;
import com.pj.sayyo.model.voting.dto.VotingDto;

public interface VotingService {

    int regist(VotingDto votingDto);
    int delete(VotingDto votingDto);
    List<VotingDto> findAll();
    int voteScore(VotingDto votingDto);
    int voted(VotedDto votedDto);
    int findVoted(VotedDto votedDto);
    int candidates(VotedDto votedDto);

    // votedata
    int votedata(VotedataDto votedataDto);
    int getRegion(VotedataDto votedataDto);
    int getGender(VotedataDto votedataDto);
    int getAge(VotedataDto votedataDto);
    int getRegionWho(VotedataDto votedataDto);
    int getGenderWho(VotedataDto votedataDto);
    int getAgeWho(VotedataDto votedataDto);
}
