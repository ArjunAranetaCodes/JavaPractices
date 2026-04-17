package com.journal.repository;

import com.journal.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

    List<JournalEntry> findByMoodIgnoreCase(String mood);

    List<JournalEntry> findByEntryDateBetween(LocalDate start, LocalDate end);

    List<JournalEntry> findByTitleContainingIgnoreCase(String title);
}
