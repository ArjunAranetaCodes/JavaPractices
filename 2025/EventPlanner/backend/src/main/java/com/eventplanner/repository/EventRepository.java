package com.eventplanner.repository;

import com.eventplanner.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(e.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Event> searchEvents(@Param("query") String query);

    List<Event> findByCategory(Event.Category category);
    List<Event> findByStatus(Event.Status status);
    List<Event> findByPriority(Event.Priority priority);
    List<Event> findByEventDate(LocalDate eventDate);
    
    @Query("SELECT e FROM Event e WHERE e.eventDate >= :today ORDER BY e.eventDate ASC, e.eventTime ASC")
    List<Event> findUpcomingEvents(@Param("today") LocalDate today);
}

