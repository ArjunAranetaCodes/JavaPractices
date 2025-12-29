import { Component, OnInit } from '@angular/core';
import { GoalService } from './services/goal.service';
import { Goal } from './models/goal';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  goals: Goal[] = [];
  filteredGoals: Goal[] = [];
  searchTerm: string = '';
  selectedStatus: string = '';
  selectedCategory: string = '';
  selectedPriority: string = '';
  categories: string[] = ['Career', 'Health', 'Finance', 'Personal', 'Education', 'Relationships', 'Travel', 'Creative'];
  showModal: boolean = false;
  editingGoal: Goal | null = null;
  newGoal: Goal = {
    title: '',
    description: '',
    category: '',
    priority: 'MEDIUM',
    status: 'ACTIVE',
    progress: 0
  };

  constructor(private goalService: GoalService) {}

  ngOnInit() {
    this.loadGoals();
  }

  loadGoals() {
    this.goalService.getAllGoals().subscribe(
      (goals) => {
        this.goals = goals;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading goals:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.goals];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.goalService.searchGoals(this.searchTerm).subscribe(
        (searchedGoals) => {
          filtered = searchedGoals;
          this.applyStatusCategoryAndPriorityFilters(filtered);
        },
        (error) => {
          console.error('Error searching goals:', error);
        }
      );
    } else {
      this.applyStatusCategoryAndPriorityFilters(filtered);
    }
  }

  applyStatusCategoryAndPriorityFilters(goals: Goal[]) {
    let filtered = [...goals];

    // Apply status filter
    if (this.selectedStatus && this.selectedStatus !== '') {
      filtered = filtered.filter(goal => goal.status === this.selectedStatus);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(goal => goal.category === this.selectedCategory);
    }

    // Apply priority filter
    if (this.selectedPriority && this.selectedPriority !== '') {
      filtered = filtered.filter(goal => goal.priority === this.selectedPriority);
    }

    this.filteredGoals = filtered;
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

  openModal(goal?: Goal) {
    if (goal) {
      this.editingGoal = { ...goal };
      this.newGoal = { ...goal };
    } else {
      this.editingGoal = null;
      this.newGoal = {
        title: '',
        description: '',
        category: '',
        priority: 'MEDIUM',
        status: 'ACTIVE',
        progress: 0
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingGoal = null;
  }

  saveGoal() {
    if (this.editingGoal) {
      this.updateGoal();
    } else {
      this.createGoal();
    }
  }

  createGoal() {
    this.goalService.createGoal(this.newGoal).subscribe(
      (goal) => {
        this.goals.push(goal);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating goal:', error);
      }
    );
  }

  updateGoal() {
    if (this.editingGoal && this.editingGoal.id) {
      this.goalService.updateGoal(this.editingGoal.id, this.newGoal).subscribe(
        (goal) => {
          const index = this.goals.findIndex(g => g.id === goal.id);
          if (index !== -1) {
            this.goals[index] = goal;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating goal:', error);
        }
      );
    }
  }

  updateProgress(goal: Goal, progress: number) {
    if (goal.id) {
      this.goalService.updateProgress(goal.id, progress).subscribe(
        (updatedGoal) => {
          const index = this.goals.findIndex(g => g.id === updatedGoal.id);
          if (index !== -1) {
            this.goals[index] = updatedGoal;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error updating progress:', error);
        }
      );
    }
  }

  completeGoal(goal: Goal) {
    if (goal.id) {
      this.goalService.completeGoal(goal.id).subscribe(
        (updatedGoal) => {
          const index = this.goals.findIndex(g => g.id === updatedGoal.id);
          if (index !== -1) {
            this.goals[index] = updatedGoal;
          }
          this.applyFilters();
        },
        (error) => {
          console.error('Error completing goal:', error);
        }
      );
    }
  }

  deleteGoal(id: number) {
    if (confirm('Are you sure you want to delete this goal?')) {
      this.goalService.deleteGoal(id).subscribe(
        () => {
          this.goals = this.goals.filter(g => g.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting goal:', error);
        }
      );
    }
  }

  getActiveCount(): number {
    return this.goals.filter(goal => goal.status === 'ACTIVE' || goal.status === 'IN_PROGRESS').length;
  }

  getCompletedCount(): number {
    return this.goals.filter(goal => goal.status === 'COMPLETED').length;
  }

  getAverageProgress(): number {
    if (this.goals.length === 0) return 0;
    const total = this.goals.reduce((sum, goal) => sum + (goal.progress || 0), 0);
    return Math.round(total / this.goals.length);
  }

  isOverdue(goal: Goal): boolean {
    if (!goal.targetDate) return false;
    const today = new Date();
    const target = new Date(goal.targetDate);
    return target < today && goal.status !== 'COMPLETED';
  }

  formatDate(dateString?: string): string {
    if (!dateString) return 'No deadline';
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', { year: 'numeric', month: 'short', day: 'numeric' });
  }
}


