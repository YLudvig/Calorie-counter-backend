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

    @Query("""
                SELECT new com.calcounterbackend.calcounterbackend.dto.WeightTrackingDTO(
                    w.weightTrackingId,
                    w.userId,
                    w.inputWeekDay,
                    w.dailycalories,
                    w.week,
                    w.weight
                )
                FROM WeightTracking w
                WHERE w.userId = :userId
            """)
    List<WeightTrackingDTO> findDTOByUserId(UUID userId);
}
