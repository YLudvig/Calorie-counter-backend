package com.calcounterbackend.calcounterbackend.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mealitem {
    // Id för varan
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID mealId;

    private UUID userId;

    // Namn
    private String name;

    // Antal kalorier
    private double calories;

    // Antal protein
    private double protein;

    // Antal kolhydrater
    private double carbs;

    // Antal fett
    private double fats;

    // Antal fiber
    private double fiber;

    // Vikt av mål
    private double weight;

    // Måltypen
    private String mealtype;

    // Datum
    private LocalDate date;

    public Mealitem(String name, double calories, double protein, double carbs, double fats, double fiber,
            double weight, String mealtype, LocalDate date) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.fiber = fiber;
        this.weight = weight;
        this.mealtype = mealtype;
        this.date = date;
    }

}
