package com.calcounterbackend.calcounterbackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcounterbackend.calcounterbackend.dto.WeightTrackingDTO;
import com.calcounterbackend.calcounterbackend.model.WeightTracking;
import com.calcounterbackend.calcounterbackend.repository.WeightTrackingRepository;

@Service
public class WeightTrackingService {

    @Autowired
    private WeightTrackingRepository weightTrackingRepository;

    public List<WeightTrackingDTO> getWeightTrackingItems(UUID userId) {
        return weightTrackingRepository.findDTOByUserId(userId);
    }

    public WeightTracking saveWeightTrackingItem(WeightTracking weightTracking) {
       return weightTrackingRepository.save(weightTracking);
    }
    
}
