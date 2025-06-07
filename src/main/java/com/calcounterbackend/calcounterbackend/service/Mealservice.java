package com.calcounterbackend.calcounterbackend.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcounterbackend.calcounterbackend.model.Mealitem;
import com.calcounterbackend.calcounterbackend.repository.Mealrepository;

@Service
public class Mealservice {

    @Autowired
    private Mealrepository mealrepository; 

    public List<Mealitem> getAll(){
        return mealrepository.findAll();
    }

    public List<Mealitem> getMealItemByUserIdAndDate(UUID userId, LocalDate date) {
        return mealrepository.findAllByUserIdAndDate(userId, date);
    }

    public Mealitem saveMealitem(Mealitem mealitem){
        return mealrepository.save(mealitem);
    }

    public void deleteMealItem(UUID mealId) {
        mealrepository.deleteById(mealId);
    }

}
