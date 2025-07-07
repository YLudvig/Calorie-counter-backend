package com.calcounterbackend.calcounterbackend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calcounterbackend.calcounterbackend.dto.DailyTotalDTO;
import com.calcounterbackend.calcounterbackend.dto.TypeTotalDTO;
import com.calcounterbackend.calcounterbackend.model.Mealitem;
import com.calcounterbackend.calcounterbackend.service.Mealservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/meal")
public class Mealcontroller {

    @Autowired
    private Mealservice mealservice;

    @GetMapping("/getAll")
    public List<Mealitem> getAllMealItems() {
        return mealservice.getAll();
    }

    @GetMapping("/getByUserIdAndDate")
    public List<Mealitem> getMealItemByUserIdAndDate(@RequestParam UUID userId, @RequestParam LocalDate date){
        return mealservice.getMealItemByUserIdAndDate(userId, date);
    }

    @GetMapping("/getByUserId")
    public List<Mealitem> getMealItemByUserIdAndDate(@RequestParam UUID userId){
        return mealservice.getMealItemByUserId(userId);
    }

    @GetMapping("/getTypeTotals")
    public List<TypeTotalDTO> getTypeTotals(@RequestParam UUID userId, @RequestParam LocalDate date){
        return mealservice.getTypeTotals(userId, date);
    }

    @GetMapping("/getDailyTotal")
    public DailyTotalDTO getDailyTotal(@RequestParam UUID userId, @RequestParam LocalDate date){
        return mealservice.getDailyTotal(userId, date);
    }

    @PostMapping("/add")
    public String saveMealItem(@Valid @RequestBody Mealitem mealitem) {
        mealservice.saveMealitem(mealitem);
        return "Meal saved";
    }

    @DeleteMapping("/delete")
    public String deleteMealItem(@RequestParam UUID mealId, @RequestParam UUID userId){
        mealservice.deleteMealItem(mealId, userId);
        return "Mealitem deleted";
    }

    @PatchMapping("/patchWeight")
    public String patchMealItem(@Valid @RequestBody Mealitem mealitem){
        mealservice.saveMealitem(mealitem);
        return "Mealitem vikt patchad för " + mealitem.getName();
    }


}
