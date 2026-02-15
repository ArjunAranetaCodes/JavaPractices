import { Component, OnInit } from '@angular/core';
import { NoteService } from './services/note.service';
import { Note } from './models/note';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  notes: Note[] = [];
  filteredNotes: Note[] = [];
  searchTerm: string = '';
  selectedCategory: string = '';
  categories: string[] = ['Personal', 'Work', 'Ideas', 'Shopping', 'Reminders', 'Other'];
  showModal: boolean = false;
  editingNote: Note | null = null;
  newNote: Note = {
    title: '',
    content: '',
    category: ''
  };

  constructor(private noteService: NoteService) {}

  ngOnInit() {
    this.loadNotes();
  }

  loadNotes() {
    this.noteService.getAllNotes().subscribe(
      (notes) => {
        this.notes = notes;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading notes:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.notes];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.noteService.searchNotes(this.searchTerm).subscribe(
        (searchedNotes) => {
          filtered = searchedNotes;
          this.applyCategoryFilter(filtered);
        },
        (error) => {
          console.error('Error searching notes:', error);
        }
      );
    } else {
      this.applyCategoryFilter(filtered);
    }
  }

  applyCategoryFilter(notes: Note[]) {
    if (this.selectedCategory && this.selectedCategory !== '') {
      this.filteredNotes = notes.filter(note => note.category === this.selectedCategory);
    } else {
      this.filteredNotes = notes;
    }
  }

  onSearchChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedCategory = '';
    this.applyFilters();
  }

  openModal(note?: Note) {
    if (note) {
      this.editingNote = { ...note };
      this.newNote = { ...note };
    } else {
      this.editingNote = null;
      this.newNote = {
        title: '',
        content: '',
        category: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingNote = null;
  }

  saveNote() {
    if (this.editingNote) {
      this.updateNote();
    } else {
      this.createNote();
    }
  }

  createNote() {
    this.noteService.createNote(this.newNote).subscribe(
      (note) => {
        this.notes.push(note);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating note:', error);
      }
    );
  }

  updateNote() {
    if (this.editingNote && this.editingNote.id) {
      this.noteService.updateNote(this.editingNote.id, this.newNote).subscribe(
        (note) => {
          const index = this.notes.findIndex(n => n.id === note.id);
          if (index !== -1) {
            this.notes[index] = note;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating note:', error);
        }
      );
    }
  }

  deleteNote(id: number) {
    if (confirm('Are you sure you want to delete this note?')) {
      this.noteService.deleteNote(id).subscribe(
        () => {
          this.notes = this.notes.filter(n => n.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting note:', error);
        }
      );
    }
  }

  getNotePreview(content: string): string {
    if (!content) return '';
    return content.length > 150 ? content.substring(0, 150) + '...' : content;
  }

  formatDate(dateString?: string): string {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', { 
      year: 'numeric', 
      month: 'short', 
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    });
  }
}

