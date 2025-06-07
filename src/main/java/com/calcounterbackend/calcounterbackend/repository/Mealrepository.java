package com.calcounterbackend.calcounterbackend.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.model.Mealitem;

@Repository
public interface Mealrepository extends JpaRepository <Mealitem, UUID>{

    List<Mealitem> findAllByUserIdAndDate(UUID userId, LocalDate date);
    
}
