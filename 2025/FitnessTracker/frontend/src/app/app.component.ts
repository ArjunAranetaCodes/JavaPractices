import { Component, OnInit } from '@angular/core';
import { WorkoutService } from './services/workout.service';
import { Workout } from './models/workout';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  workouts: Workout[] = [];
  filteredWorkouts: Workout[] = [];
  searchTerm: string = '';
  selectedType: string = '';
  selectedCategory: string = '';
  selectedDate: string = '';
  
  exerciseTypes = ['CARDIO', 'STRENGTH', 'FLEXIBILITY', 'SPORTS', 'YOGA', 'PILATES', 'CROSSFIT', 'OTHER'];
  categories = ['FULL_BODY', 'UPPER_BODY', 'LOWER_BODY', 'CORE', 'ARMS', 'LEGS', 'BACK', 'CHEST', 'SHOULDERS', 'OTHER'];
  
  showModal: boolean = false;
  editingWorkout: Workout | null = null;
  newWorkout: Workout = {
    name: '',
    exerciseType: 'STRENGTH',
    category: 'FULL_BODY',
    workoutDate: '',
    durationMinutes: 0,
    sets: 0,
    reps: 0,
    weight: 0,
    distance: 0,
    caloriesBurned: 0,
    notes: ''
  };

  constructor(private workoutService: WorkoutService) {}

  ngOnInit() {
    this.loadWorkouts();
  }

  loadWorkouts() {
    this.workoutService.getAllWorkouts().subscribe(
      (workouts) => {
        this.workouts = workouts;
        this.applyFilters();
      },
      (error) => {
        console.error('Error loading workouts:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.workouts];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.workoutService.searchWorkouts(this.searchTerm).subscribe(
        (searchedWorkouts) => {
          filtered = searchedWorkouts;
          this.applyOtherFilters(filtered);
        },
        (error) => {
          console.error('Error searching workouts:', error);
          this.applyOtherFilters(filtered);
        }
      );
    } else {
      this.applyOtherFilters(filtered);
    }
  }

  applyOtherFilters(workouts: Workout[]) {
    let filtered = [...workouts];

    // Apply type filter
    if (this.selectedType && this.selectedType !== '') {
      filtered = filtered.filter(workout => workout.exerciseType === this.selectedType);
    }

    // Apply category filter
    if (this.selectedCategory && this.selectedCategory !== '') {
      filtered = filtered.filter(workout => workout.category === this.selectedCategory);
    }

    // Apply date filter
    if (this.selectedDate && this.selectedDate !== '') {
      filtered = filtered.filter(workout => workout.workoutDate === this.selectedDate);
    }

    // Sort by date (most recent first)
    filtered.sort((a, b) => {
      return b.workoutDate.localeCompare(a.workoutDate);
    });

    this.filteredWorkouts = filtered;
  }

  onSearchChange() {
    this.applyFilters();
  }

  onTypeChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  onDateChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedType = '';
    this.selectedCategory = '';
    this.selectedDate = '';
    this.applyFilters();
  }

  openModal(workout?: Workout) {
    if (workout) {
      this.editingWorkout = { ...workout };
      this.newWorkout = { ...workout };
    } else {
      this.editingWorkout = null;
      this.newWorkout = {
        name: '',
        exerciseType: 'STRENGTH',
        category: 'FULL_BODY',
        workoutDate: '',
        durationMinutes: 0,
        sets: 0,
        reps: 0,
        weight: 0,
        distance: 0,
        caloriesBurned: 0,
        notes: ''
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingWorkout = null;
  }

  saveWorkout() {
    if (this.editingWorkout) {
      this.updateWorkout();
    } else {
      this.createWorkout();
    }
  }

  createWorkout() {
    this.workoutService.createWorkout(this.newWorkout).subscribe(
      (workout) => {
        this.workouts.push(workout);
        this.applyFilters();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating workout:', error);
      }
    );
  }

  updateWorkout() {
    if (this.editingWorkout && this.editingWorkout.id) {
      this.workoutService.updateWorkout(this.editingWorkout.id, this.newWorkout).subscribe(
        (workout) => {
          const index = this.workouts.findIndex(w => w.id === workout.id);
          if (index !== -1) {
            this.workouts[index] = workout;
          }
          this.applyFilters();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating workout:', error);
        }
      );
    }
  }

  deleteWorkout(id: number) {
    if (confirm('Are you sure you want to delete this workout?')) {
      this.workoutService.deleteWorkout(id).subscribe(
        () => {
          this.workouts = this.workouts.filter(w => w.id !== id);
          this.applyFilters();
        },
        (error) => {
          console.error('Error deleting workout:', error);
        }
      );
    }
  }

  getTotalCount(): number {
    return this.workouts.length;
  }

  getTotalCalories(): number {
    return this.workouts.reduce((sum, workout) => sum + (workout.caloriesBurned || 0), 0);
  }

  getTotalDuration(): number {
    return this.workouts.reduce((sum, workout) => sum + (workout.durationMinutes || 0), 0);
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

  formatDuration(minutes: number | undefined): string {
    if (!minutes || minutes === 0) return 'N/A';
    if (minutes < 60) return `${minutes}m`;
    const hours = Math.floor(minutes / 60);
    const remainingMinutes = minutes % 60;
    return `${hours}h ${remainingMinutes}m`;
  }
}

