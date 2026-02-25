package com.projectmanagement.repository;

import com.projectmanagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Project> searchProjects(@Param("query") String query);

    List<Project> findByStatus(Project.Status status);
    List<Project> findByPriority(Project.Priority priority);
    List<Project> findByCategory(Project.Category category);
}

