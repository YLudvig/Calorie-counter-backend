package com.calcounterbackend.calcounterbackend.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeightTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID weightTrackingId;

    private UUID userId;

    private double dailycalories;

    private String inputWeekDay;

    private int week;

    private double weight;
}
