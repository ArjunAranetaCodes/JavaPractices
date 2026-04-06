import { Component, OnInit } from '@angular/core';
import { Bookmark } from '../../models/bookmark.model';
import { BookmarkService } from '../../services/bookmark.service';

@Component({
  selector: 'app-bookmark-list',
  templateUrl: './bookmark-list.component.html',
  styleUrls: ['./bookmark-list.component.css']
})
export class BookmarkListComponent implements OnInit {
  bookmarks: Bookmark[] = [];
  filtered: Bookmark[] = [];
  searchTerm = '';
  selectedCategory = 'all';
  categories: string[] = ['all', 'Work', 'Learning', 'Tools', 'Social', 'News', 'Other'];
  showModal = false;
  isEditMode = false;
  editingBookmark: Bookmark | null = null;

  constructor(private service: BookmarkService) {}

  ngOnInit(): void {
    this.loadBookmarks();
  }

  loadBookmarks(): void {
    this.service.getAll().subscribe({
      next: (data) => {
        this.bookmarks = data;
        const cats = new Set(data.map(b => b.category).filter(Boolean));
        if (cats.size > 0) {
          this.categories = ['all', ...Array.from(cats).sort()];
        }
        this.applyFilters();
      },
      error: (err) => console.error('Error loading bookmarks', err)
    });
  }

  applyFilters(): void {
    let result = [...this.bookmarks];
    if (this.selectedCategory !== 'all') {
      result = result.filter(b => (b.category || '').toLowerCase() === this.selectedCategory.toLowerCase());
    }
    if (this.searchTerm.trim()) {
      const term = this.searchTerm.toLowerCase();
      result = result.filter(b =>
        (b.title || '').toLowerCase().includes(term) ||
        (b.url || '').toLowerCase().includes(term) ||
        (b.notes || '').toLowerCase().includes(term)
      );
    }
    this.filtered = result;
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onCategoryChange(): void {
    this.applyFilters();
  }

  openUrl(url: string): void {
    if (url) {
      window.open(url.startsWith('http') ? url : 'https://' + url, '_blank');
    }
  }

  openAddModal(): void {
    this.isEditMode = false;
    this.editingBookmark = {
      title: '',
      url: '',
      category: 'Work',
      notes: ''
    };
    this.showModal = true;
  }

  openEditModal(bookmark: Bookmark): void {
    this.isEditMode = true;
    this.editingBookmark = { ...bookmark };
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.editingBookmark = null;
    this.isEditMode = false;
  }

  saveBookmark(bookmark: Bookmark): void {
    if (this.isEditMode && bookmark.id) {
      this.service.update(bookmark.id, bookmark).subscribe({
        next: () => {
          this.loadBookmarks();
          this.closeModal();
        },
        error: (err) => console.error('Error updating bookmark', err)
      });
    } else {
      this.service.create(bookmark).subscribe({
        next: () => {
          this.loadBookmarks();
          this.closeModal();
        },
        error: (err) => console.error('Error creating bookmark', err)
      });
    }
  }

  deleteBookmark(id: number): void {
    if (!confirm('Delete this bookmark?')) return;
    this.service.delete(id).subscribe({
      next: () => this.loadBookmarks(),
      error: (err) => console.error('Error deleting bookmark', err)
    });
  }
}
