package com.calcounterbackend.calcounterbackend.service;

import java.util.List;

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

    public Mealitem saveMealitem(Mealitem mealitem){
        return mealrepository.save(mealitem);
    }

}
