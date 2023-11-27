package com.pj.sayyo.service.calendar;


import com.pj.sayyo.model.calendar.dto.CalendarDto;

import java.util.List;

public interface CalendarService {
    List<CalendarDto> getAllEvents();
}