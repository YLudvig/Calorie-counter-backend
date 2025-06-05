package com.calcounterbackend.calcounterbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcounterbackend.calcounterbackend.model.Mealitem;
import com.calcounterbackend.calcounterbackend.service.Mealservice;

import lombok.ToString;

@RestController
@RequestMapping("/api/meal")
public class Mealcontroller {

    @Autowired
    private Mealservice mealservice;

    @GetMapping("/getAll")
    public List<Mealitem> getAllMealItems() {
        return mealservice.getAll();
    }

    @PostMapping("/add")
    public String saveMealItem(@RequestBody Mealitem mealitem) {
        mealservice.saveMealitem(mealitem);
        System.out.println(mealitem);
        return "Meal saved";
    }

}
