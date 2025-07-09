package com.calcounterbackend.calcounterbackend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.dto.AVGDTO;
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

    @Query(value = """
            SELECT
              curr.week,
              curr.avg_weight,
              curr.avg_calories,
              curr.avg_weight - prev.avg_weight AS delta_weight
            FROM
              (
                SELECT
                  week,
                  AVG(weight) AS avg_weight,
                  AVG(dailycalories) AS avg_calories
                FROM
                  weight_tracking
                WHERE user_id = :userId
                GROUP BY
                  week
              ) curr
            LEFT JOIN
              (
                SELECT
                  week,
                  AVG(weight) AS avg_weight
                FROM
                  weight_tracking
                WHERE user_id = :userId
                GROUP BY
                  week
              ) prev ON curr.week = prev.week + 1
            ORDER BY
              curr.week
            """, nativeQuery = true)
    List<AVGDTO> findAveragesByUserId(@Param("userId") UUID userId);
}
