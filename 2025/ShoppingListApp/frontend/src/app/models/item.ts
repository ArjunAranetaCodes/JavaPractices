export interface Item {
  id?: number;
  name: string;
  description?: string;
  category?: string;
  quantity?: number;
  priority?: 'LOW' | 'MEDIUM' | 'HIGH';
  status?: 'PENDING' | 'COMPLETED';
  createdAt?: string;
  updatedAt?: string;
}

