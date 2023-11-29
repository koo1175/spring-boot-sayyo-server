package com.pj.sayyo.service.calendar;

import com.pj.sayyo.model.calendar.dto.CalendarDto;
import com.pj.sayyo.model.calendar.mapper.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements  CalendarService{

    @Autowired
    private CalendarMapper calendarMapper;
    @Override
    public List<CalendarDto> getAllEvents() {
        return calendarMapper.getAllEvents();
    }
}
