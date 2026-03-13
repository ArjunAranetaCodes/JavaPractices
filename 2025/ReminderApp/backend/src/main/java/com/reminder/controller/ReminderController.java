package com.reminder.controller;

import com.reminder.model.Reminder;
import com.reminder.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
@CrossOrigin(origins = "http://localhost:4200")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = reminderService.getAllReminders();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id) {
        Reminder reminder = reminderService.getReminderById(id);
        if (reminder != null) {
            return ResponseEntity.ok(reminder);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Reminder>> searchReminders(@RequestParam String query) {
        List<Reminder> reminders = reminderService.searchReminders(query);
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Reminder>> getRemindersByStatus(@PathVariable String status) {
        try {
            Reminder.Status reminderStatus = Reminder.Status.valueOf(status.toUpperCase());
            List<Reminder> reminders = reminderService.getRemindersByStatus(reminderStatus);
            return ResponseEntity.ok(reminders);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Reminder>> getRemindersByCategory(@PathVariable String category) {
        List<Reminder> reminders = reminderService.getRemindersByCategory(category);
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Reminder>> getRemindersByPriority(@PathVariable String priority) {
        try {
            Reminder.Priority reminderPriority = Reminder.Priority.valueOf(priority.toUpperCase());
            List<Reminder> reminders = reminderService.getRemindersByPriority(reminderPriority);
            return ResponseEntity.ok(reminders);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Reminder>> getUpcomingReminders() {
        List<Reminder> reminders = reminderService.getUpcomingReminders();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Reminder>> getOverdueReminders() {
        List<Reminder> reminders = reminderService.getOverdueReminders();
        return ResponseEntity.ok(reminders);
    }

    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        Reminder created = reminderService.createReminder(reminder);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        Reminder updated = reminderService.updateReminder(id, reminder);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Reminder> markAsCompleted(@PathVariable Long id) {
        Reminder updated = reminderService.markAsCompleted(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        boolean deleted = reminderService.deleteReminder(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


