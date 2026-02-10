package com.notes.controller;

import com.notes.model.Note;
import com.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(@RequestParam String query) {
        List<Note> notes = noteService.searchNotes(query);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Note>> getNotesByCategory(@PathVariable String category) {
        List<Note> notes = noteService.getNotesByCategory(category);
        return ResponseEntity.ok(notes);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note created = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note updated = noteService.updateNote(id, note);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        boolean deleted = noteService.deleteNote(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

