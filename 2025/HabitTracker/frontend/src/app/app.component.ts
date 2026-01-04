import { Component, OnInit } from '@angular/core';
import { HabitService } from './services/habit.service';
import { Habit } from './models/habit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  habits: Habit[] = [];
  filteredHabits: Habit[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedCategory: string = '';
  categories: string[] = ['Health', 'Fitness', 'Learning', 'Productivity', 'Personal', 'Social', 'Financial', 'Creative'];
  showModal: boolean = false;
  editingHabit: Habit | null = null;
  newHabit: Habit = {
    name: '',
    description: '',
    category: '',
    frequency: 'DAILY',
    status: 'ACTIVE'
  };

  constructor(private habitService: HabitService) {}

  ngOnInit() {
    this.loadHabits();
  }

  loadHabits() {
    this.habitService.getAllHabits().subscribe(
      (habits) => {
        this.habits = habits;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading habits:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.habits];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.habitService.searchHabits(this.searchTerm).subscribe(
        (searchedHabits) => {
          filtered = searchedHabits;
          this.applyStatusAndCategoryFilters(filtered);
        },
        (error) => {
          console.error('Error searching habits:', error);
        }
      );
    } else {
      this.applyStatusAndCategoryFilters(filtered);
    }
  }

  applyStatusAndCategoryFilters(habits: Habit[]) {
    let filtered = [...habits];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(habit => habit.status === this.selectedStatus);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(habit => habit.category === this.selectedCategory);
    }

    this.filteredHabits = filtered;
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

  clearFilters() {
    this.searchTerm = '';
    this.selectedStatus = '';
    this.selectedCategory = '';
    this.applyFilters();
  }

  openModal(habit?: Habit) {
    if (habit) {
      this.editingHabit = { ...habit };
      this.newHabit = { ...habit };
    } else {
      this.editingHabit = null;
      this.newHabit = {
        name: '',
        description: '',
        category: '',
        frequency: 'DAILY',
        status: 'ACTIVE'
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingHabit = null;
  }

  saveHabit() {
    if (this.editingHabit) {
      this.updateHabit();
    } else {
      this.createHabit();
    }
  }

  createHabit() {
    this.habitService.createHabit(this.newHabit).subscribe(
      (habit) => {
        this.habits.push(habit);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating habit:', error);
      }
    );
  }

  updateHabit() {
    if (this.editingHabit && this.editingHabit.id) {
      this.habitService.updateHabit(this.editingHabit.id, this.newHabit).subscribe(
        (habit) => {
          const index = this.habits.findIndex(h => h.id === habit.id);
          if (index !== -1) {
            this.habits[index] = habit;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating habit:', error);
        }
      );
    }
  }

  completeHabit(habit: Habit) {
    if (habit.id) {
      this.habitService.completeHabit(habit.id).subscribe(
        (updatedHabit) => {
          const index = this.habits.findIndex(h => h.id === updatedHabit.id);
          if (index !== -1) {
            this.habits[index] = updatedHabit;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error completing habit:', error);
        }
      );
    }
  }

  resetStreak(habit: Habit) {
    if (habit.id && confirm('Are you sure you want to reset the streak?')) {
      this.habitService.resetHabitStreak(habit.id).subscribe(
        (updatedHabit) => {
          const index = this.habits.findIndex(h => h.id === updatedHabit.id);
          if (index !== -1) {
            this.habits[index] = updatedHabit;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error resetting streak:', error);
        }
      );
    }
  }

  deleteHabit(id: number) {
    if (confirm('Are you sure you want to delete this habit?')) {
      this.habitService.deleteHabit(id).subscribe(
        () => {
          this.habits = this.habits.filter(h => h.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting habit:', error);
        }
      );
    }
  }

  getActiveCount(): number {
    return this.habits.filter(habit => habit.status === 'ACTIVE').length;
  }

  getTotalStreak(): number {
    return this.habits.reduce((sum, habit) => sum + (habit.currentStreak || 0), 0);
  }

  getLongestStreak(): number {
    return Math.max(...this.habits.map(h => h.longestStreak || 0), 0);
  }

  isCompletedToday(habit: Habit): boolean {
    if (!habit.lastCompletedDate) return false;
    const today = new Date().toISOString().split('T')[0];
    return habit.lastCompletedDate === today;
  }
}

