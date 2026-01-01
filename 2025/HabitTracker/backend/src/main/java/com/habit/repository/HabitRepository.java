package com.habit.repository;

import com.habit.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    @Query("SELECT h FROM Habit h WHERE LOWER(h.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Habit> searchByName(@Param("query") String query);

    List<Habit> findByCategory(String category);
    List<Habit> findByStatus(Habit.Status status);
}

