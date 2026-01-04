package com.habit.service;

import com.habit.model.Habit;
import com.habit.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Habit getHabitById(Long id) {
        Optional<Habit> habit = habitRepository.findById(id);
        return habit.orElse(null);
    }

    public List<Habit> searchHabits(String query) {
        return habitRepository.searchByName(query);
    }

    public List<Habit> getHabitsByCategory(String category) {
        return habitRepository.findByCategory(category);
    }

    public List<Habit> getHabitsByStatus(Habit.Status status) {
        return habitRepository.findByStatus(status);
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit updateHabit(Long id, Habit habitDetails) {
        Optional<Habit> optionalHabit = habitRepository.findById(id);
        if (optionalHabit.isPresent()) {
            Habit habit = optionalHabit.get();
            habit.setName(habitDetails.getName());
            habit.setDescription(habitDetails.getDescription());
            habit.setCategory(habitDetails.getCategory());
            habit.setFrequency(habitDetails.getFrequency());
            habit.setStatus(habitDetails.getStatus());
            return habitRepository.save(habit);
        }
        return null;
    }

    public Habit completeHabit(Long id) {
        Optional<Habit> optionalHabit = habitRepository.findById(id);
        if (optionalHabit.isPresent()) {
            Habit habit = optionalHabit.get();
            LocalDate today = LocalDate.now();
            LocalDate lastCompleted = habit.getLastCompletedDate();

            // If last completed is today, don't increment
            if (lastCompleted != null && lastCompleted.equals(today)) {
                return habit;
            }

            // If last completed is yesterday, increment streak
            if (lastCompleted != null && lastCompleted.equals(today.minusDays(1))) {
                habit.setCurrentStreak(habit.getCurrentStreak() + 1);
            } else if (lastCompleted == null || lastCompleted.isBefore(today.minusDays(1))) {
                // If missed a day or first time, reset to 1
                habit.setCurrentStreak(1);
            }

            // Update longest streak if current is longer
            if (habit.getCurrentStreak() > habit.getLongestStreak()) {
                habit.setLongestStreak(habit.getCurrentStreak());
            }

            habit.setLastCompletedDate(today);
            return habitRepository.save(habit);
        }
        return null;
    }

    public Habit resetHabitStreak(Long id) {
        Optional<Habit> optionalHabit = habitRepository.findById(id);
        if (optionalHabit.isPresent()) {
            Habit habit = optionalHabit.get();
            habit.setCurrentStreak(0);
            habit.setLastCompletedDate(null);
            return habitRepository.save(habit);
        }
        return null;
    }

    public boolean deleteHabit(Long id) {
        if (habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

