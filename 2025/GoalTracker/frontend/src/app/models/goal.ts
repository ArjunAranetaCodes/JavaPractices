export interface Goal {
  id?: number;
  title: string;
  description?: string;
  category?: string;
  priority?: 'HIGH' | 'MEDIUM' | 'LOW';
  status?: 'ACTIVE' | 'IN_PROGRESS' | 'COMPLETED' | 'CANCELLED';
  progress?: number;
  targetDate?: string;
  createdAt?: string;
  updatedAt?: string;
}


