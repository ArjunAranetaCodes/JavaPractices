package com.habit.controller;

import com.habit.model.Habit;
import com.habit.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
@CrossOrigin(origins = "http://localhost:4200")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @GetMapping
    public ResponseEntity<List<Habit>> getAllHabits() {
        List<Habit> habits = habitService.getAllHabits();
        return ResponseEntity.ok(habits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habit> getHabitById(@PathVariable Long id) {
        Habit habit = habitService.getHabitById(id);
        if (habit != null) {
            return ResponseEntity.ok(habit);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Habit>> searchHabits(@RequestParam String query) {
        List<Habit> habits = habitService.searchHabits(query);
        return ResponseEntity.ok(habits);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Habit>> getHabitsByCategory(@PathVariable String category) {
        List<Habit> habits = habitService.getHabitsByCategory(category);
        return ResponseEntity.ok(habits);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Habit>> getHabitsByStatus(@PathVariable String status) {
        try {
            Habit.Status habitStatus = Habit.Status.valueOf(status.toUpperCase());
            List<Habit> habits = habitService.getHabitsByStatus(habitStatus);
            return ResponseEntity.ok(habits);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit) {
        Habit created = habitService.createHabit(habit);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long id, @RequestBody Habit habit) {
        Habit updated = habitService.updateHabit(id, habit);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Habit> completeHabit(@PathVariable Long id) {
        Habit updated = habitService.completeHabit(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/reset")
    public ResponseEntity<Habit> resetHabitStreak(@PathVariable Long id) {
        Habit updated = habitService.resetHabitStreak(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        boolean deleted = habitService.deleteHabit(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

