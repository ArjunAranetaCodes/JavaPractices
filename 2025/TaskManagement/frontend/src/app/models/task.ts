export interface Task {
  id?: number;
  title: string;
  description?: string;
  priority?: 'LOW' | 'MEDIUM' | 'HIGH' | 'URGENT';
  status?: 'TODO' | 'IN_PROGRESS' | 'DONE' | 'CANCELLED';
  category?: 'WORK' | 'PERSONAL' | 'SHOPPING' | 'HEALTH' | 'EDUCATION' | 'OTHER';
  dueDate?: string; // ISO date string (YYYY-MM-DD)
  assignee?: string;
  tags?: string;
  createdAt?: string;
  updatedAt?: string;
}

