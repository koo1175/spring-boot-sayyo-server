package com.pj.sayyo.controller.calendar;

import com.pj.sayyo.model.calendar.dto.CalendarDto;
import com.pj.sayyo.model.calendar.mapper.CalendarMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CalController {
    private final CalendarMapper calendarMapper;


    public CalController(CalendarMapper calendarMapper) {
        this.calendarMapper = calendarMapper;
    }

    @GetMapping("/api/events")
    public List<CalendarDto> getAllEvents() {
        return calendarMapper.getAllEvents();
    }
}