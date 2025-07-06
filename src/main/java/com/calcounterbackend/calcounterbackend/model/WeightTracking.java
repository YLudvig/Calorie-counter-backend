package com.calcounterbackend.calcounterbackend.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
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

    private double weight;

    private double dailycalories;

    private LocalDate date;

}
