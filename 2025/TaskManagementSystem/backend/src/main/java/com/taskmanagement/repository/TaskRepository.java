package com.taskmanagement.repository;

import com.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByStatus(Task.TaskStatus status);
    
    List<Task> findByPriority(Task.TaskPriority priority);
    
    List<Task> findByAssignedTo(String assignedTo);
    
    List<Task> findByCreatedBy(String createdBy);
    
    List<Task> findByDueDate(LocalDate dueDate);
    
    List<Task> findByDueDateBefore(LocalDate date);
    
    @Query("SELECT t FROM Task t WHERE t.dueDate < :date AND t.status != 'COMPLETED'")
    List<Task> findOverdueTasks(@Param("date") LocalDate date);
    
    @Query("SELECT t FROM Task t WHERE " +
           "LOWER(t.title) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(t.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Task> searchTasks(@Param("query") String query);
    
    @Query("SELECT t FROM Task t WHERE t.assignedTo = :assignedTo AND t.status = :status")
    List<Task> findByAssignedToAndStatus(@Param("assignedTo") String assignedTo, 
                                         @Param("status") Task.TaskStatus status);
}

