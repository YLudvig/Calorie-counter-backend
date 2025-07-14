package com.calcounterbackend.calcounterbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcounterbackend.calcounterbackend.repository.CalendarDateRepository;

@Service
public class CalendarDateService {

    @Autowired
    private CalendarDateRepository calendarDateRepository;

    public Integer getCurrentWeek() {
        return calendarDateRepository.getCurrentWeek();
    }

}
