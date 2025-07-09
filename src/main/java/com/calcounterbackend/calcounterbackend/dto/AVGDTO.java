package com.calcounterbackend.calcounterbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AVGDTO {
    Integer week; 
    Double avg_calories; 
    Double avg_weight; 
}