package com.calcounterbackend.calcounterbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcounterbackend.calcounterbackend.model.CalendarDate;
import com.calcounterbackend.calcounterbackend.service.CalendarDateService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendardate")
public class CalendarDateController {
    
    private final CalendarDateService calendarDateService; 

    @GetMapping("/getAllDatesAndWeeks")
    public List<CalendarDate> getAllDatesAndWeeks(){
        return calendarDateService.getAllDatesAndWeeks();
    }

    @GetMapping("/getAllWeeks")
    public List<Integer> getAllWeeks(){
        return calendarDateService.getAllWeeks();
    }

}
