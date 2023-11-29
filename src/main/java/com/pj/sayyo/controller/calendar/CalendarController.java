package com.pj.sayyo.controller.calendar;

import com.pj.sayyo.model.calendar.dto.CalendarDto;
import com.pj.sayyo.service.calendar.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/api/events")
    public List<CalendarDto> getAllEvents() {
        return calendarService.getAllEvents();
    }
}