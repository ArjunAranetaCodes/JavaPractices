package com.journal.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "journal_entries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 8000)
    private String content;

    @Column(nullable = false)
    private LocalDate entryDate;

    @Column(length = 20)
    private String mood; // HAPPY, NEUTRAL, SAD

    public JournalEntry() {
    }

    public JournalEntry(String title, String content, LocalDate entryDate, String mood) {
        this.title = title;
        this.content = content;
        this.entryDate = entryDate;
        this.mood = mood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
