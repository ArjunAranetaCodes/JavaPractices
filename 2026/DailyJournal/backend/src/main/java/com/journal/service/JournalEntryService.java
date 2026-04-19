package com.journal.service;

import com.journal.model.JournalEntry;
import com.journal.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalEntryService {

    private final JournalEntryRepository repository;

    public JournalEntryService(JournalEntryRepository repository) {
        this.repository = repository;
    }

    public List<JournalEntry> getAll() {
        return repository.findAll();
    }

    public JournalEntry getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal entry not found with id " + id));
    }

    public List<JournalEntry> getByMood(String mood) {
        if (mood == null || mood.isBlank()) return getAll();
        return repository.findByMoodIgnoreCase(mood.trim());
    }

    public List<JournalEntry> getByDateRange(LocalDate start, LocalDate end) {
        if (start == null || end == null) return getAll();
        return repository.findByEntryDateBetween(start, end);
    }

    public List<JournalEntry> search(String term) {
        if (term == null || term.isBlank()) return getAll();
        return repository.findByTitleContainingIgnoreCase(term.trim());
    }

    public JournalEntry create(JournalEntry entry) {
        return repository.save(entry);
    }

    public JournalEntry update(Long id, JournalEntry data) {
        JournalEntry existing = getById(id);
        existing.setTitle(data.getTitle());
        existing.setContent(data.getContent());
        existing.setEntryDate(data.getEntryDate());
        existing.setMood(data.getMood());
        return repository.save(existing);
    }

    public void delete(Long id) {
        JournalEntry existing = getById(id);
        repository.delete(existing);
    }
}
