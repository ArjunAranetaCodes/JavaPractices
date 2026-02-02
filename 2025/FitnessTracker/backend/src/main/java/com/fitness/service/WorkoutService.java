package com.fitness.service;

import com.fitness.model.Workout;
import com.fitness.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id) {
        Optional<Workout> workout = workoutRepository.findById(id);
        return workout.orElse(null);
    }

    public List<Workout> searchWorkouts(String query) {
        return workoutRepository.searchWorkouts(query);
    }

    public List<Workout> getWorkoutsByExerciseType(Workout.ExerciseType exerciseType) {
        return workoutRepository.findByExerciseType(exerciseType);
    }

    public List<Workout> getWorkoutsByCategory(Workout.Category category) {
        return workoutRepository.findByCategory(category);
    }

    public List<Workout> getWorkoutsByDate(LocalDate date) {
        return workoutRepository.findByWorkoutDate(date);
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout updateWorkout(Long id, Workout workoutDetails) {
        Optional<Workout> optionalWorkout = workoutRepository.findById(id);
        if (optionalWorkout.isPresent()) {
            Workout workout = optionalWorkout.get();
            workout.setName(workoutDetails.getName());
            workout.setExerciseType(workoutDetails.getExerciseType());
            workout.setCategory(workoutDetails.getCategory());
            workout.setWorkoutDate(workoutDetails.getWorkoutDate());
            workout.setDurationMinutes(workoutDetails.getDurationMinutes());
            workout.setSets(workoutDetails.getSets());
            workout.setReps(workoutDetails.getReps());
            workout.setWeight(workoutDetails.getWeight());
            workout.setDistance(workoutDetails.getDistance());
            workout.setCaloriesBurned(workoutDetails.getCaloriesBurned());
            workout.setNotes(workoutDetails.getNotes());
            return workoutRepository.save(workout);
        }
        return null;
    }

    public boolean deleteWorkout(Long id) {
        if (workoutRepository.existsById(id)) {
            workoutRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

