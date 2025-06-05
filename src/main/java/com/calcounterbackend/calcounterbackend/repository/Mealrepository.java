package com.calcounterbackend.calcounterbackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.model.Mealitem;

@Repository
public interface Mealrepository extends JpaRepository <Mealitem, UUID>{
    
}
