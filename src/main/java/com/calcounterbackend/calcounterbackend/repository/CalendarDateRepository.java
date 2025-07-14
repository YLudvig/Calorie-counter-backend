package com.calcounterbackend.calcounterbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.model.CalendarDate;

@Repository
public interface CalendarDateRepository extends JpaRepository<CalendarDate, Long> {

        @Query(value = """
                SELECT id, week_number, day_name, the_date
                FROM calendar_date
                ORDER BY week_number, the_date
        """, nativeQuery = true)
        List<CalendarDate> getAllDays();

        @Query(value = """
                SELECT WEEK(CURDATE(), 3) 
                AS current_week;
        """, nativeQuery = true)
        Integer getCurrentWeek();

}
