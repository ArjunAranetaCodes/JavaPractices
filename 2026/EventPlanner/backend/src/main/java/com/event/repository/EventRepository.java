package com.event.repository;

import com.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByCategoryIgnoreCase(String category);

    List<Event> findByStatusIgnoreCase(String status);

    List<Event> findByStartDateTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Event> findByTitleContainingIgnoreCase(String title);
}
