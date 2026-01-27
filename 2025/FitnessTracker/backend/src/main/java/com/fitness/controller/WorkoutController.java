package com.fitness.controller;

import com.fitness.model.Workout;
import com.fitness.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        List<Workout> workouts = workoutService.getAllWorkouts();
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
        Workout workout = workoutService.getWorkoutById(id);
        if (workout != null) {
            return ResponseEntity.ok(workout);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Workout>> searchWorkouts(@RequestParam String query) {
        List<Workout> workouts = workoutService.searchWorkouts(query);
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Workout>> getWorkoutsByType(@PathVariable String type) {
        try {
            Workout.ExerciseType exerciseType = Workout.ExerciseType.valueOf(type.toUpperCase());
            List<Workout> workouts = workoutService.getWorkoutsByExerciseType(exerciseType);
            return ResponseEntity.ok(workouts);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Workout>> getWorkoutsByCategory(@PathVariable String category) {
        try {
            Workout.Category workoutCategory = Workout.Category.valueOf(category.toUpperCase());
            List<Workout> workouts = workoutService.getWorkoutsByCategory(workoutCategory);
            return ResponseEntity.ok(workouts);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Workout>> getWorkoutsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Workout> workouts = workoutService.getWorkoutsByDate(date);
        return ResponseEntity.ok(workouts);
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        Workout created = workoutService.createWorkout(workout);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        Workout updated = workoutService.updateWorkout(id, workout);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        boolean deleted = workoutService.deleteWorkout(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

