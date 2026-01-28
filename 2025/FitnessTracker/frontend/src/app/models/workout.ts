export interface Workout {
  id?: number;
  name: string;
  exerciseType?: 'CARDIO' | 'STRENGTH' | 'FLEXIBILITY' | 'SPORTS' | 'YOGA' | 'PILATES' | 'CROSSFIT' | 'OTHER';
  category?: 'FULL_BODY' | 'UPPER_BODY' | 'LOWER_BODY' | 'CORE' | 'ARMS' | 'LEGS' | 'BACK' | 'CHEST' | 'SHOULDERS' | 'OTHER';
  workoutDate: string; // ISO date string (YYYY-MM-DD)
  durationMinutes?: number;
  sets?: number;
  reps?: number;
  weight?: number;
  distance?: number;
  caloriesBurned?: number;
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}

