package com.calcounterbackend.calcounterbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.model.CalendarDate;

@Repository
public interface CalendarDateRepository extends JpaRepository<CalendarDate, Long> {

    @Query(value = """
            SELECT *
            FROM calendar_date
            order by the_date
            """, nativeQuery = true)
    List<CalendarDate> getAllDays();

    @Query(value = """
            SELECT distinct week_number
            FROM calendar_date
            order by week_number    
            """, nativeQuery = true)
    List<Integer> getAllWeeks();

}
