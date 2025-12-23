package com.goal.controller;

import com.goal.model.Goal;
import com.goal.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "http://localhost:4200")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping
    public ResponseEntity<List<Goal>> getAllGoals() {
        List<Goal> goals = goalService.getAllGoals();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        Goal goal = goalService.getGoalById(id);
        if (goal != null) {
            return ResponseEntity.ok(goal);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Goal>> searchGoals(@RequestParam String query) {
        List<Goal> goals = goalService.searchGoals(query);
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Goal>> getGoalsByStatus(@PathVariable String status) {
        try {
            Goal.Status goalStatus = Goal.Status.valueOf(status.toUpperCase());
            List<Goal> goals = goalService.getGoalsByStatus(goalStatus);
            return ResponseEntity.ok(goals);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Goal>> getGoalsByCategory(@PathVariable String category) {
        List<Goal> goals = goalService.getGoalsByCategory(category);
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Goal>> getGoalsByPriority(@PathVariable String priority) {
        try {
            Goal.Priority goalPriority = Goal.Priority.valueOf(priority.toUpperCase());
            List<Goal> goals = goalService.getGoalsByPriority(goalPriority);
            return ResponseEntity.ok(goals);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal created = goalService.createGoal(goal);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        Goal updated = goalService.updateGoal(id, goal);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/progress")
    public ResponseEntity<Goal> updateProgress(@PathVariable Long id, @RequestBody Integer progress) {
        Goal updated = goalService.updateProgress(id, progress);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Goal> completeGoal(@PathVariable Long id) {
        Goal updated = goalService.completeGoal(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        boolean deleted = goalService.deleteGoal(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


