package com.calcounterbackend.calcounterbackend.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeightTrackingDTO {
    private UUID weightTrackingId;
    private UUID userId;
    private String inputWeekDay;
    private Double dailycalories;
    private int week;
    private Double weight;
}
