package com.goal.repository;

import com.goal.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    @Query("SELECT g FROM Goal g WHERE LOWER(g.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(g.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Goal> searchByTitleOrDescription(@Param("query") String query);

    List<Goal> findByCategory(String category);
    List<Goal> findByStatus(Goal.Status status);
    List<Goal> findByPriority(Goal.Priority priority);
}


