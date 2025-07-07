package com.calcounterbackend.calcounterbackend.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcounterbackend.calcounterbackend.model.CalendarDate;
import com.calcounterbackend.calcounterbackend.repository.CalendarDateRepository;

@Service
public class CalendarDateService {

    @Autowired
    private CalendarDateRepository calendarDateRepository;

    public List<Integer> getAllWeeks() {
        return calendarDateRepository.getAllWeeks();
    }

}
