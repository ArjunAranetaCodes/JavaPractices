export interface Recipe {
  id?: number;
  name: string;
  description?: string;
  ingredients?: string;
  instructions?: string;
  prepTime?: number;
  cookTime?: number;
  servings?: number;
  difficulty?: 'EASY' | 'MEDIUM' | 'HARD';
  category?: string;
  rating?: number;
  imageUrl?: string;
  createdAt?: string;
  updatedAt?: string;
  totalTime?: number;
}
