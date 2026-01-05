export interface Habit {
  id?: number;
  name: string;
  description?: string;
  category?: string;
  frequency?: 'DAILY' | 'WEEKLY' | 'CUSTOM';
  currentStreak?: number;
  longestStreak?: number;
  status?: 'ACTIVE' | 'PAUSED' | 'COMPLETED';
  lastCompletedDate?: string;
  createdAt?: string;
  updatedAt?: string;
}

