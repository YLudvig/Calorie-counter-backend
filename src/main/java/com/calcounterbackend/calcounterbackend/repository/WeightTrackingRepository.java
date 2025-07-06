package com.calcounterbackend.calcounterbackend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.model.WeightTracking;

@Repository
public interface WeightTrackingRepository extends JpaRepository<WeightTracking, UUID> {

    @Query(value = """
            SELECT *
            FROM weight_tracking 
            where user_id = :userId
            """, nativeQuery = true)
    List<WeightTracking> getWeightTrackingItems(UUID userId);
    
}
