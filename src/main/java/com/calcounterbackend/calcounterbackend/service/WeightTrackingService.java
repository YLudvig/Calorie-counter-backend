package com.calcounterbackend.calcounterbackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcounterbackend.calcounterbackend.model.WeightTracking;
import com.calcounterbackend.calcounterbackend.repository.WeightTrackingRepository;

@Service
public class WeightTrackingService {

    @Autowired
    private WeightTrackingRepository weightTrackingRepository;

    public List<WeightTracking> getWeightTrackingItems(UUID userId) {
        return weightTrackingRepository.getWeightTrackingItems(userId);
    }
    
}
