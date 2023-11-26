package com.pj.sayyo.model.calendar.mapper;

import com.pj.sayyo.model.calendar.dto.CalendarDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CalendarMapper {
    List<CalendarDto> getAllEvents();
}
