package com.pj.sayyo.service.laws;

import com.pj.sayyo.model.laws.dto.LawsDto;

import java.util.List;

public interface LawsService {
    List<LawsDto> findAll();
}
