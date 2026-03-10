package com.reminder.service;

import com.reminder.model.Reminder;
import com.reminder.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public Reminder getReminderById(Long id) {
        Optional<Reminder> reminder = reminderRepository.findById(id);
        return reminder.orElse(null);
    }

    public List<Reminder> searchReminders(String query) {
        return reminderRepository.searchByTitleOrDescription(query);
    }

    public List<Reminder> getRemindersByCategory(String category) {
        return reminderRepository.findByCategory(category);
    }

    public List<Reminder> getRemindersByStatus(Reminder.Status status) {
        return reminderRepository.findByStatus(status);
    }

    public List<Reminder> getRemindersByPriority(Reminder.Priority priority) {
        return reminderRepository.findByPriority(priority);
    }

    public List<Reminder> getUpcomingReminders() {
        return reminderRepository.findUpcomingReminders(LocalDateTime.now());
    }

    public List<Reminder> getOverdueReminders() {
        return reminderRepository.findOverdueReminders(LocalDateTime.now());
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public Reminder updateReminder(Long id, Reminder reminderDetails) {
        Optional<Reminder> optionalReminder = reminderRepository.findById(id);
        if (optionalReminder.isPresent()) {
            Reminder reminder = optionalReminder.get();
            reminder.setTitle(reminderDetails.getTitle());
            reminder.setDescription(reminderDetails.getDescription());
            reminder.setReminderDate(reminderDetails.getReminderDate());
            reminder.setPriority(reminderDetails.getPriority());
            reminder.setStatus(reminderDetails.getStatus());
            reminder.setCategory(reminderDetails.getCategory());
            return reminderRepository.save(reminder);
        }
        return null;
    }

    public Reminder markAsCompleted(Long id) {
        Optional<Reminder> optionalReminder = reminderRepository.findById(id);
        if (optionalReminder.isPresent()) {
            Reminder reminder = optionalReminder.get();
            reminder.setStatus(Reminder.Status.COMPLETED);
            return reminderRepository.save(reminder);
        }
        return null;
    }

    public boolean deleteReminder(Long id) {
        if (reminderRepository.existsById(id)) {
            reminderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


