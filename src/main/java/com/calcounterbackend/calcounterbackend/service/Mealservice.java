package com.calcounterbackend.calcounterbackend.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calcounterbackend.calcounterbackend.dto.DailyTotalDTO;
import com.calcounterbackend.calcounterbackend.dto.TypeTotalDTO;
import com.calcounterbackend.calcounterbackend.model.Mealitem;
import com.calcounterbackend.calcounterbackend.repository.Mealrepository;

@Service
public class Mealservice {

    @Autowired
    private Mealrepository mealrepository;

    public List<Mealitem> getAll() {
        return mealrepository.findAll();
    }

    public List<Mealitem> getMealItemByUserIdAndDate(UUID userId, LocalDate date) {
        return mealrepository.findAllByUserIdAndDate(userId, date);
    }

    public List<TypeTotalDTO> getTypeTotals(UUID userId, LocalDate date) {
        return mealrepository.findTypeTotals(userId, date);
    }

    public List<Mealitem> getMealItemByUserId(UUID userId) {
        return mealrepository.findAllByUserId(userId);
    }

    public DailyTotalDTO getDailyTotal(UUID userId, LocalDate date) {
        return mealrepository.getDailyTotal(userId, date);
    }

    public Mealitem saveMealitem(Mealitem mealitem) {
        return mealrepository.save(mealitem);
    }

    @Transactional
    public void deleteMealItem(UUID mealId, UUID userId) {
        mealrepository.deleteByMealIdAndUserId(mealId, userId);
    }



}
