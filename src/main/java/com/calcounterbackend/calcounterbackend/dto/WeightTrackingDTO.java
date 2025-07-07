package com.calcounterbackend.calcounterbackend.dto;

import java.util.UUID;

public interface WeightTrackingDTO {
    UUID getWeightTrackingId();
    String getInputWeekDay();
    Double getDailyCalories();  
    int getWeek();  
    Double getWeight(); 
}
