package com.bookmark.service;

import com.bookmark.model.Bookmark;
import com.bookmark.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    private final BookmarkRepository repository;

    public BookmarkService(BookmarkRepository repository) {
        this.repository = repository;
    }

    public List<Bookmark> getAll() {
        return repository.findAll();
    }

    public Bookmark getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookmark not found with id " + id));
    }

    public List<Bookmark> getByCategory(String category) {
        if (category == null || category.isBlank()) {
            return getAll();
        }
        return repository.findByCategoryIgnoreCase(category.trim());
    }

    public List<Bookmark> search(String term) {
        if (term == null || term.isBlank()) {
            return getAll();
        }
        return repository.findByTitleContainingIgnoreCaseOrUrlContainingIgnoreCase(term, term);
    }

    public Bookmark create(Bookmark bookmark) {
        return repository.save(bookmark);
    }

    public Bookmark update(Long id, Bookmark data) {
        Bookmark existing = getById(id);
        existing.setTitle(data.getTitle());
        existing.setUrl(data.getUrl());
        existing.setCategory(data.getCategory());
        existing.setNotes(data.getNotes());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Bookmark existing = getById(id);
        repository.delete(existing);
    }
}
