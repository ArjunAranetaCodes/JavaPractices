import { Component, OnInit } from '@angular/core';
import { EventItem } from '../../models/event.model';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  events: EventItem[] = [];
  filtered: EventItem[] = [];
  searchTerm = '';
  selectedStatus = 'all';
  selectedCategory = 'all';
  statuses = ['all', 'PLANNED', 'COMPLETED', 'CANCELLED'];
  categories: string[] = ['all', 'Work', 'Personal', 'Birthday', 'Other'];
  showModal = false;
  isEditMode = false;
  editingEvent: EventItem | null = null;

  constructor(private service: EventService) {}

  ngOnInit(): void {
    this.loadEvents();
  }

  loadEvents(): void {
    this.service.getAll().subscribe({
      next: (data) => {
        this.events = data;
        const cats = new Set(data.map(e => e.category).filter(Boolean));
        if (cats.size > 0) {
          this.categories = ['all', ...Array.from(cats).sort()];
        }
        this.applyFilters();
      },
      error: (err) => console.error('Error loading events', err)
    });
  }

  applyFilters(): void {
    let result = [...this.events];
    if (this.selectedStatus !== 'all') {
      result = result.filter(e => (e.status || '').toUpperCase() === this.selectedStatus.toUpperCase());
    }
    if (this.selectedCategory !== 'all') {
      result = result.filter(e => (e.category || '').toLowerCase() === this.selectedCategory.toLowerCase());
    }
    if (this.searchTerm.trim()) {
      const term = this.searchTerm.toLowerCase();
      result = result.filter(e =>
        (e.title || '').toLowerCase().includes(term) ||
        (e.description || '').toLowerCase().includes(term)
      );
    }
    result.sort((a, b) => (a.startDateTime || '').localeCompare(b.startDateTime || ''));
    this.filtered = result;
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onStatusChange(): void {
    this.applyFilters();
  }

  onCategoryChange(): void {
    this.applyFilters();
  }

  statusClass(status: string): string {
    const s = (status || '').toUpperCase();
    if (s === 'PLANNED') return 'planned';
    if (s === 'COMPLETED') return 'completed';
    if (s === 'CANCELLED') return 'cancelled';
    return '';
  }

  formatWhen(start: string, end: string): string {
    const s = this.formatLocal(start);
    const e = this.formatLocal(end);
    return `${s} → ${e}`;
  }

  private formatLocal(iso: string): string {
    if (!iso) return '';
    const d = new Date(iso);
    if (isNaN(d.getTime())) return iso;
    return d.toLocaleString();
  }

  openAddModal(): void {
    const now = new Date();
    const oneHour = new Date(now.getTime() + 3600000);
    this.isEditMode = false;
    this.editingEvent = {
      title: '',
      description: '',
      location: '',
      startDateTime: this.toLocalInput(now),
      endDateTime: this.toLocalInput(oneHour),
      category: 'Work',
      status: 'PLANNED'
    };
    this.showModal = true;
  }

  private toLocalInput(d: Date): string {
    const pad = (n: number) => n.toString().padStart(2, '0');
    return `${d.getFullYear()}-${pad(d.getMonth() + 1)}-${pad(d.getDate())}T${pad(d.getHours())}:${pad(d.getMinutes())}`;
  }

  openEditModal(ev: EventItem): void {
    this.isEditMode = true;
    this.editingEvent = {
      ...ev,
      startDateTime: this.isoToLocalInput(ev.startDateTime),
      endDateTime: this.isoToLocalInput(ev.endDateTime)
    };
    this.showModal = true;
  }

  private isoToLocalInput(iso: string): string {
    if (!iso) return '';
    const d = new Date(iso);
    if (isNaN(d.getTime())) return iso.slice(0, 16);
    return this.toLocalInput(d);
  }

  closeModal(): void {
    this.showModal = false;
    this.editingEvent = null;
    this.isEditMode = false;
  }

  saveEvent(event: EventItem): void {
    if (this.isEditMode && event.id) {
      this.service.update(event.id, event).subscribe({
        next: () => {
          this.loadEvents();
          this.closeModal();
        },
        error: (err) => console.error('Error updating event', err)
      });
    } else {
      this.service.create(event).subscribe({
        next: () => {
          this.loadEvents();
          this.closeModal();
        },
        error: (err) => console.error('Error creating event', err)
      });
    }
  }

  deleteEvent(id: number): void {
    if (!confirm('Delete this event?')) return;
    this.service.delete(id).subscribe({
      next: () => this.loadEvents(),
      error: (err) => console.error('Error deleting event', err)
    });
  }
}
