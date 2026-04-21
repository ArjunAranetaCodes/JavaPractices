import { Component, OnInit } from '@angular/core';
import { ReminderService } from './services/reminder.service';
import { Reminder } from './models/reminder';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  reminders: Reminder[] = [];
  filteredReminders: Reminder[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedCategory: string = '';
  selectedPriority: string = '';
  categories: string[] = ['Work', 'Personal', 'Health', 'Shopping', 'Bills', 'Appointments', 'Events', 'Other'];
  showModal: boolean = false;
  editingReminder: Reminder | null = null;
  newReminder: Reminder = {
    title: '',
    description: '',
    reminderDate: '',
    priority: 'MEDIUM',
    status: 'PENDING',
    category: ''
  };

  constructor(private reminderService: ReminderService) {}

  ngOnInit() {
    this.loadReminders();
  }

  loadReminders() {
    this.reminderService.getAllReminders().subscribe(
      (reminders) => {
        this.reminders = reminders;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading reminders:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.reminders];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.reminderService.searchReminders(this.searchTerm).subscribe(
        (searchedReminders) => {
          filtered = searchedReminders;
          this.applyStatusCategoryAndPriorityFilters(filtered);
        },
        (error) => {
          console.error('Error searching reminders:', error);
        }
      );
    } else {
      this.applyStatusCategoryAndPriorityFilters(filtered);
    }
  }

  applyStatusCategoryAndPriorityFilters(reminders: Reminder[]) {
    let filtered = [...reminders];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(reminder => reminder.status === this.selectedStatus);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(reminder => reminder.category === this.selectedCategory);
    }

    // Apply priority filter
    if (this.selectedPriority && this.selectedPriority !== '') {
      filtered = filtered.filter(reminder => reminder.priority === this.selectedPriority);
    }

    this.filteredReminders = filtered;
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

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedCategory = '';
    this.selectedPriority = '';
    this.applyFilters();
  }

  openModal(reminder?: Reminder) {
    if (reminder) {
      this.editingReminder = { ...reminder };
      this.newReminder = { ...reminder };
      // Format date for datetime-local input
      if (this.newReminder.reminderDate) {
        const date = new Date(this.newReminder.reminderDate);
        const localDate = new Date(date.getTime() - date.getTimezoneOffset() * 60000);
        this.newReminder.reminderDate = localDate.toISOString().slice(0, 16);
      }
    } else {
      this.editingReminder = null;
      this.newReminder = {
        title: '',
        description: '',
        reminderDate: '',
        priority: 'MEDIUM',
        status: 'PENDING',
        category: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingReminder = null;
  }

  saveReminder() {
    if (this.editingReminder) {
      this.updateReminder();
    } else {
      this.createReminder();
    }
  }

  createReminder() {
    this.reminderService.createReminder(this.newReminder).subscribe(
      (reminder) => {
        this.reminders.push(reminder);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating reminder:', error);
      }
    );
  }

  updateReminder() {
    if (this.editingReminder && this.editingReminder.id) {
      this.reminderService.updateReminder(this.editingReminder.id, this.newReminder).subscribe(
        (reminder) => {
          const index = this.reminders.findIndex(r => r.id === reminder.id);
          if (index !== -1) {
            this.reminders[index] = reminder;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating reminder:', error);
        }
      );
    }
  }

  markAsCompleted(reminder: Reminder) {
    if (reminder.id) {
      this.reminderService.markAsCompleted(reminder.id).subscribe(
        (updatedReminder) => {
          const index = this.reminders.findIndex(r => r.id === updatedReminder.id);
          if (index !== -1) {
            this.reminders[index] = updatedReminder;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error marking reminder as completed:', error);
        }
      );
    }
  }

  deleteReminder(id: number) {
    if (confirm('Are you sure you want to delete this reminder?')) {
      this.reminderService.deleteReminder(id).subscribe(
        () => {
          this.reminders = this.reminders.filter(r => r.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting reminder:', error);
        }
      );
    }
  }

  getPendingCount(): number {
    return this.reminders.filter(r => r.status === 'PENDING').length;
  }

  getCompletedCount(): number {
    return this.reminders.filter(r => r.status === 'COMPLETED').length;
  }

  getOverdueCount(): number {
    const now = new Date();
    return this.reminders.filter(r => {
      if (r.status !== 'PENDING' || !r.reminderDate) return false;
      return new Date(r.reminderDate) < now;
    }).length;
  }

  isOverdue(reminder: Reminder): boolean {
    if (!reminder.reminderDate || reminder.status !== 'PENDING') return false;
    return new Date(reminder.reminderDate) < new Date();
  }

  formatDateTime(dateString: string | undefined): string {
    if (!dateString) return 'No date set';
    const date = new Date(dateString);
    return date.toLocaleString('en-US', {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    });
  }

  getTimeUntil(dateString: string | undefined): string {
    if (!dateString) return '';
    const date = new Date(dateString);
    const now = new Date();
    const diff = date.getTime() - now.getTime();
    
    if (diff < 0) return 'Overdue';
    
    const days = Math.floor(diff / (1000 * 60 * 60 * 24));
    const hours = Math.floor((diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60));
    
    if (days > 0) return `${days}d ${hours}h`;
    if (hours > 0) return `${hours}h ${minutes}m`;
    return `${minutes}m`;
  }
}


