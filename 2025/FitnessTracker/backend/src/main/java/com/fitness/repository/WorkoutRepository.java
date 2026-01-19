package com.fitness.repository;

import com.fitness.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    @Query("SELECT w FROM Workout w WHERE LOWER(w.name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(w.notes) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Workout> searchWorkouts(@Param("query") String query);

    List<Workout> findByExerciseType(Workout.ExerciseType exerciseType);
    List<Workout> findByCategory(Workout.Category category);
    List<Workout> findByWorkoutDate(LocalDate workoutDate);
}

