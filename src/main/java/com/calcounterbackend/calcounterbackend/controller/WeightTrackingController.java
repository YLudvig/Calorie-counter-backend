package com.calcounterbackend.calcounterbackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calcounterbackend.calcounterbackend.dto.AVGDTO;
import com.calcounterbackend.calcounterbackend.dto.WeightTrackingDTO;
import com.calcounterbackend.calcounterbackend.model.WeightTracking;
import com.calcounterbackend.calcounterbackend.service.WeightTrackingService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weighttracking")
public class WeightTrackingController {
    
    private final WeightTrackingService weightTrackingService; 

    @GetMapping("/getAllWeightTrackingItemsByUserId")
    public List<WeightTrackingDTO> getAllWeightTrackingItems(@RequestParam UUID userId) {
        return weightTrackingService.getWeightTrackingItems(userId);
    }

    @GetMapping("/getAveragesByUserId")
    public List<AVGDTO> getAverages(@RequestParam UUID userId) {
        return weightTrackingService.getAverages(userId);
    }

    @PostMapping("/addWeightAndCalories")
    public String saveWeightTrackingItem(@Valid @RequestBody WeightTracking weightTracking) {
        weightTrackingService.saveWeightTrackingItem(weightTracking);
        return "Calories and weight saved";
    }

    @PatchMapping("/patchWeightAndCalories")
    public WeightTracking patchWeightTrackingItem(@RequestBody WeightTracking weightTracking){
        return weightTrackingService.saveWeightTrackingItem(weightTracking);
    }
}