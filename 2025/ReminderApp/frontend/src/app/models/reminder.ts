export interface Reminder {
  id?: number;
  title: string;
  description?: string;
  reminderDate?: string;
  priority?: 'HIGH' | 'MEDIUM' | 'LOW';
  status?: 'PENDING' | 'COMPLETED' | 'CANCELLED';
  category?: string;
  createdAt?: string;
  updatedAt?: string;
}


