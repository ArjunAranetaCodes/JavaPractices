import { Component, OnInit } from '@angular/core';
import { EventService } from './services/event.service';
import { Event } from './models/event';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  events: Event[] = [];
  filteredEvents: Event[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedCategory: string = '';
  selectedPriority: string = '';
  selectedDate: string = '';
  
  categories = ['MEETING', 'BIRTHDAY', 'WEDDING', 'CONFERENCE', 'WORKSHOP', 'CONCERT', 
                'SPORTS', 'HOLIDAY', 'ANNIVERSARY', 'PARTY', 'SEMINAR', 'EXHIBITION', 'OTHER'];
  statuses = ['UPCOMING', 'IN_PROGRESS', 'COMPLETED', 'CANCELLED'];
  priorities = ['HIGH', 'MEDIUM', 'LOW'];
  
  showModal: boolean = false;
  editingEvent: Event | null = null;
  newEvent: Event = {
    title: '',
    description: '',
    eventDate: '',
    eventTime: '',
    location: '',
    category: 'MEETING',
    status: 'UPCOMING',
    priority: 'MEDIUM',
    notes: ''
  };

  constructor(private eventService: EventService) {}

  ngOnInit() {
    this.loadEvents();
  }

  loadEvents() {
    this.eventService.getAllEvents().subscribe(
      (events) => {
        this.events = events;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading events:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.events];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.eventService.searchEvents(this.searchTerm).subscribe(
        (searchedEvents) => {
          filtered = searchedEvents;
          this.applyOtherFilters(filtered);
        },
        (error) => {
          console.error('Error searching events:', error);
          this.applyOtherFilters(filtered);
        }
      );
    } else {
      this.applyOtherFilters(filtered);
    }
  }

  applyOtherFilters(events: Event[]) {
    let filtered = [...events];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(event => event.status === this.selectedStatus);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(event => event.category === this.selectedCategory);
    }

    // Apply priority filter
    if (this.selectedPriority && this.selectedPriority !== '') {
      filtered = filtered.filter(event => event.priority === this.selectedPriority);
    }

    // Apply date filter
    if (this.selectedDate && this.selectedDate !== '') {
      filtered = filtered.filter(event => event.eventDate === this.selectedDate);
    }

    // Sort by date and time
    filtered.sort((a, b) => {
      const dateCompare = a.eventDate.localeCompare(b.eventDate);
      if (dateCompare !== 0) return dateCompare;
      if (a.eventTime && b.eventTime) {
        return a.eventTime.localeCompare(b.eventTime);
      }
      return 0;
    });

    this.filteredEvents = filtered;
  }

  onSearchChange() {
    this.applyFilters();
  }

  onStatusChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  onPriorityChange() {
    this.applyFilters();
  }

  onDateChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedCategory = '';
    this.selectedPriority = '';
    this.selectedDate = '';
    this.applyFilters();
  }

  openModal(event?: Event) {
    if (event) {
      this.editingEvent = { ...event };
      this.newEvent = { ...event };
    } else {
      this.editingEvent = null;
      this.newEvent = {
        title: '',
        description: '',
        eventDate: '',
        eventTime: '',
        location: '',
        category: 'MEETING',
        status: 'UPCOMING',
        priority: 'MEDIUM',
        notes: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingEvent = null;
  }

  saveEvent() {
    if (this.editingEvent) {
      this.updateEvent();
    } else {
      this.createEvent();
    }
  }

  createEvent() {
    this.eventService.createEvent(this.newEvent).subscribe(
      (event) => {
        this.events.push(event);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating event:', error);
      }
    );
  }

  updateEvent() {
    if (this.editingEvent && this.editingEvent.id) {
      this.eventService.updateEvent(this.editingEvent.id, this.newEvent).subscribe(
        (event) => {
          const index = this.events.findIndex(e => e.id === event.id);
          if (index !== -1) {
            this.events[index] = event;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating event:', error);
        }
      );
    }
  }

  deleteEvent(id: number) {
    if (confirm('Are you sure you want to delete this event?')) {
      this.eventService.deleteEvent(id).subscribe(
        () => {
          this.events = this.events.filter(e => e.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting event:', error);
        }
      );
    }
  }

  getTotalCount(): number {
    return this.events.length;
  }

  getUpcomingCount(): number {
    return this.events.filter(event => event.status === 'UPCOMING').length;
  }

  getCompletedCount(): number {
    return this.events.filter(event => event.status === 'COMPLETED').length;
  }

  formatDate(dateString: string): string {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', { 
      weekday: 'short', 
      year: 'numeric', 
      month: 'short', 
      day: 'numeric' 
    });
  }

  formatTime(timeString: string | undefined): string {
    if (!timeString) return '';
    return timeString;
  }

  getStatusClass(status: string | undefined): string {
    if (!status) return '';
    return `status-${status.toLowerCase()}`;
  }
}

