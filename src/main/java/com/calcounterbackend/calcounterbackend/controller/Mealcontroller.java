package com.calcounterbackend.calcounterbackend.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calcounterbackend.calcounterbackend.model.Mealitem;
import com.calcounterbackend.calcounterbackend.service.Mealservice;

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

    @PostMapping("/add")
    public String saveMealItem(@RequestBody Mealitem mealitem) {
        mealservice.saveMealitem(mealitem);
        System.out.println(mealitem);
        return "Meal saved";
    }

    @DeleteMapping("/{mealId}")
    public String deleteMealItem(@PathVariable UUID mealId){
        mealservice.deleteMealItem(mealId);
        return "Mealitem deleted";
    }

    @PatchMapping("/patchWeight")
    public String patchMealItem(@RequestBody Mealitem mealitem){
        mealservice.saveMealitem(mealitem);
        return "Mealitem vikt patchad för " + mealitem.getName();
    }


}
