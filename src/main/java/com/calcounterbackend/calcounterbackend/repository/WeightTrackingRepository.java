package com.calcounterbackend.calcounterbackend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.dto.WeightTrackingDTO;
import com.calcounterbackend.calcounterbackend.model.WeightTracking;

@Repository
public interface WeightTrackingRepository extends JpaRepository<WeightTracking, UUID> {

    @Query(value = """
            SELECT
                wt.weight_tracking_id AS weightTrackingId,
                wt.input_week_day AS inputWeekDay,
                wt.dailycalories AS dailyCalories,
                wt.week AS week,
                wt.weight AS weight
            FROM weight_tracking wt
            WHERE wt.user_id = :userId
                    """, nativeQuery = true)
    List<WeightTrackingDTO> getWeightTrackingItems(UUID userId);

}
