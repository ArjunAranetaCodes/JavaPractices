export interface ShoppingItem {
  id?: number;
  name: string;
  quantity?: number;
  unit?: string;
  priority?: 'HIGH' | 'MEDIUM' | 'LOW';
  completed?: boolean;
  category?: string;
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}







