package com.reminder.repository;

import com.reminder.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    @Query("SELECT r FROM Reminder r WHERE LOWER(r.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(r.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Reminder> searchByTitleOrDescription(@Param("query") String query);

    List<Reminder> findByCategory(String category);
    List<Reminder> findByStatus(Reminder.Status status);
    List<Reminder> findByPriority(Reminder.Priority priority);
    
    @Query("SELECT r FROM Reminder r WHERE r.reminderDate >= :now AND r.status = 'PENDING' ORDER BY r.reminderDate ASC")
    List<Reminder> findUpcomingReminders(@Param("now") LocalDateTime now);
    
    @Query("SELECT r FROM Reminder r WHERE r.reminderDate < :now AND r.status = 'PENDING' ORDER BY r.reminderDate ASC")
    List<Reminder> findOverdueReminders(@Param("now") LocalDateTime now);
}


