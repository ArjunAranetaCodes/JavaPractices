package com.journal.controller;

import com.journal.model.JournalEntry;
import com.journal.service.JournalEntryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/entries")
@CrossOrigin(origins = "http://localhost:4200")
public class JournalEntryController {

    private final JournalEntryService service;

    public JournalEntryController(JournalEntryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<JournalEntry>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> byId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/mood/{mood}")
    public ResponseEntity<List<JournalEntry>> byMood(@PathVariable String mood) {
        return ResponseEntity.ok(service.getByMood(mood));
    }

    @GetMapping("/range")
    public ResponseEntity<List<JournalEntry>> byRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(service.getByDateRange(start, end));
    }

    @GetMapping("/search")
    public ResponseEntity<List<JournalEntry>> search(@RequestParam String q) {
        return ResponseEntity.ok(service.search(q));
    }

    @PostMapping
    public ResponseEntity<JournalEntry> create(@RequestBody JournalEntry entry) {
        JournalEntry created = service.create(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> update(@PathVariable Long id, @RequestBody JournalEntry entry) {
        try {
            return ResponseEntity.ok(service.update(id, entry));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
