import { Component, OnInit } from '@angular/core';
import { JournalEntry } from '../../models/journal-entry.model';
import { JournalService } from '../../services/journal.service';

@Component({
  selector: 'app-journal-list',
  templateUrl: './journal-list.component.html',
  styleUrls: ['./journal-list.component.css']
})
export class JournalListComponent implements OnInit {
  entries: JournalEntry[] = [];
  filtered: JournalEntry[] = [];
  searchTerm = '';
  selectedMood = 'all';
  moods = ['all', 'HAPPY', 'NEUTRAL', 'SAD'];
  showModal = false;
  isEditMode = false;
  editingEntry: JournalEntry | null = null;

  constructor(private service: JournalService) {}

  ngOnInit(): void {
    this.loadEntries();
  }

  loadEntries(): void {
    this.service.getAll().subscribe({
      next: (data) => {
        this.entries = data;
        this.applyFilters();
      },
      error: (err) => console.error('Error loading entries', err)
    });
  }

  applyFilters(): void {
    let result = [...this.entries];
    if (this.selectedMood !== 'all') {
      result = result.filter(e => (e.mood || '').toUpperCase() === this.selectedMood.toUpperCase());
    }
    if (this.searchTerm.trim()) {
      const term = this.searchTerm.toLowerCase();
      result = result.filter(e =>
        (e.title || '').toLowerCase().includes(term) ||
        (e.content || '').toLowerCase().includes(term)
      );
    }
    result.sort((a, b) => (b.entryDate || '').localeCompare(a.entryDate || ''));
    this.filtered = result;
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onMoodChange(): void {
    this.applyFilters();
  }

  moodClass(mood: string): string {
    const m = (mood || '').toUpperCase();
    if (m === 'HAPPY') return 'happy';
    if (m === 'NEUTRAL') return 'neutral';
    if (m === 'SAD') return 'sad';
    return '';
  }

  openAddModal(): void {
    const today = new Date().toISOString().slice(0, 10);
    this.isEditMode = false;
    this.editingEntry = {
      title: '',
      content: '',
      entryDate: today,
      mood: 'NEUTRAL'
    };
    this.showModal = true;
  }

  openEditModal(entry: JournalEntry): void {
    this.isEditMode = true;
    this.editingEntry = { ...entry };
    if (this.editingEntry.entryDate && this.editingEntry.entryDate.length > 10) {
      this.editingEntry.entryDate = this.editingEntry.entryDate.slice(0, 10);
    }
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.editingEntry = null;
    this.isEditMode = false;
  }

  saveEntry(entry: JournalEntry): void {
    if (this.isEditMode && entry.id) {
      this.service.update(entry.id, entry).subscribe({
        next: () => {
          this.loadEntries();
          this.closeModal();
        },
        error: (err) => console.error('Error updating entry', err)
      });
    } else {
      this.service.create(entry).subscribe({
        next: () => {
          this.loadEntries();
          this.closeModal();
        },
        error: (err) => console.error('Error creating entry', err)
      });
    }
  }

  deleteEntry(id: number): void {
    if (!confirm('Delete this journal entry?')) return;
    this.service.delete(id).subscribe({
      next: () => this.loadEntries(),
      error: (err) => console.error('Error deleting entry', err)
    });
  }
}
