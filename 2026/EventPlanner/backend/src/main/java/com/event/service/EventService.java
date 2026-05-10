package com.event.service;

import com.event.model.Event;
import com.event.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAll() {
        return repository.findAll();
    }

    public Event getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    public List<Event> getByCategory(String category) {
        if (category == null || category.isBlank()) return getAll();
        return repository.findByCategoryIgnoreCase(category.trim());
    }

    public List<Event> getByStatus(String status) {
        if (status == null || status.isBlank()) return getAll();
        return repository.findByStatusIgnoreCase(status.trim());
    }

    public List<Event> getByDateRange(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return getAll();
        return repository.findByStartDateTimeBetween(start, end);
    }

    public List<Event> search(String term) {
        if (term == null || term.isBlank()) return getAll();
        return repository.findByTitleContainingIgnoreCase(term.trim());
    }

    public Event create(Event event) {
        return repository.save(event);
    }

    public Event update(Long id, Event data) {
        Event existing = getById(id);
        existing.setTitle(data.getTitle());
        existing.setDescription(data.getDescription());
        existing.setLocation(data.getLocation());
        existing.setStartDateTime(data.getStartDateTime());
        existing.setEndDateTime(data.getEndDateTime());
        existing.setCategory(data.getCategory());
        existing.setStatus(data.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Event existing = getById(id);
        repository.delete(existing);
    }
}
