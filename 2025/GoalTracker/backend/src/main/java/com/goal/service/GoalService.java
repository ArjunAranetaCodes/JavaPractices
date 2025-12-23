package com.goal.service;

import com.goal.model.Goal;
import com.goal.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(Long id) {
        Optional<Goal> goal = goalRepository.findById(id);
        return goal.orElse(null);
    }

    public List<Goal> searchGoals(String query) {
        return goalRepository.searchByTitleOrDescription(query);
    }

    public List<Goal> getGoalsByCategory(String category) {
        return goalRepository.findByCategory(category);
    }

    public List<Goal> getGoalsByStatus(Goal.Status status) {
        return goalRepository.findByStatus(status);
    }

    public List<Goal> getGoalsByPriority(Goal.Priority priority) {
        return goalRepository.findByPriority(priority);
    }

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Goal updateGoal(Long id, Goal goalDetails) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);
        if (optionalGoal.isPresent()) {
            Goal goal = optionalGoal.get();
            goal.setTitle(goalDetails.getTitle());
            goal.setDescription(goalDetails.getDescription());
            goal.setCategory(goalDetails.getCategory());
            goal.setPriority(goalDetails.getPriority());
            goal.setStatus(goalDetails.getStatus());
            goal.setProgress(goalDetails.getProgress());
            goal.setTargetDate(goalDetails.getTargetDate());
            return goalRepository.save(goal);
        }
        return null;
    }

    public Goal updateProgress(Long id, Integer progress) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);
        if (optionalGoal.isPresent()) {
            Goal goal = optionalGoal.get();
            goal.setProgress(progress);
            // Auto-update status based on progress
            if (progress >= 100 && goal.getStatus() != Goal.Status.COMPLETED) {
                goal.setStatus(Goal.Status.COMPLETED);
            } else if (progress > 0 && progress < 100 && goal.getStatus() == Goal.Status.ACTIVE) {
                goal.setStatus(Goal.Status.IN_PROGRESS);
            }
            return goalRepository.save(goal);
        }
        return null;
    }

    public Goal completeGoal(Long id) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);
        if (optionalGoal.isPresent()) {
            Goal goal = optionalGoal.get();
            goal.setProgress(100);
            goal.setStatus(Goal.Status.COMPLETED);
            return goalRepository.save(goal);
        }
        return null;
    }

    public boolean deleteGoal(Long id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


