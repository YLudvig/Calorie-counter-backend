package com.calcounterbackend.calcounterbackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calcounterbackend.calcounterbackend.model.WeightTracking;
import com.calcounterbackend.calcounterbackend.service.WeightTrackingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weighttracking")
public class WeightTrackingController {
    
    private final WeightTrackingService weightTrackingService; 

    @GetMapping("/getAllWeightTrackingItemsByUserId")
    public List<WeightTracking> getAllWeightTrackingItems(@RequestParam UUID userId) {
        return weightTrackingService.getWeightTrackingItems(userId);
    }

}
