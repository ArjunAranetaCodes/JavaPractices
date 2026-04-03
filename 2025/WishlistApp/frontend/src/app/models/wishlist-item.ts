export interface WishlistItem {
  id?: number;
  name: string;
  description?: string;
  price?: number;
  priority?: 'HIGH' | 'MEDIUM' | 'LOW';
  status?: 'WANTED' | 'PURCHASED' | 'REMOVED';
  category?: string;
  link?: string;
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}

