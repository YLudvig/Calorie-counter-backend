package com.calcounterbackend.calcounterbackend.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.model.Mealitem;

@Repository
public interface Mealrepository extends JpaRepository<Mealitem, UUID> {

    List<Mealitem> findAllByUserIdAndDate(UUID userId, LocalDate date);

    void deleteByMealIdAndUserId(UUID mealId, UUID userId);

    //SQL query som hanterar filtrering och sortering på backend och skickar en snygg lista till frontend
    @Query(value = """
            SELECT m.*
            FROM mealitem m
            JOIN (
                SELECT name, calories, protein, MAX(date) as max_date
                FROM mealitem
                WHERE user_id = :userId
                GROUP BY name, calories, protein
            ) grouped ON m.name = grouped.name
                    AND m.calories = grouped.calories
                    AND m.protein = grouped.protein
                    AND m.date = grouped.max_date
            ORDER BY m.date DESC, m.name ASC
            """, nativeQuery = true)
    List<Mealitem> findAllByUserId(UUID userId);
}
