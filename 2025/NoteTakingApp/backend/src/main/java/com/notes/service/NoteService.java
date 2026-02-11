package com.notes.service;

import com.notes.model.Note;
import com.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.orElse(null);
    }

    public List<Note> searchNotes(String query) {
        return noteRepository.searchByTitleOrContent(query);
    }

    public List<Note> getNotesByCategory(String category) {
        return noteRepository.findByCategory(category);
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());
            note.setCategory(noteDetails.getCategory());
            return noteRepository.save(note);
        }
        return null;
    }

    public boolean deleteNote(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

