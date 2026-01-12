export interface BlogPost {
  id?: number;
  title: string;
  content: string;
  author?: string;
  category?: 'TECHNOLOGY' | 'LIFESTYLE' | 'TRAVEL' | 'FOOD' | 'HEALTH' | 'BUSINESS' | 'EDUCATION' | 'ENTERTAINMENT' | 'OTHER';
  tags?: string;
  status?: 'DRAFT' | 'PUBLISHED' | 'ARCHIVED';
  publicationDate?: string; // ISO date string (YYYY-MM-DD)
  readingTime?: number;
  featured?: boolean;
  excerpt?: string;
  createdAt?: string;
  updatedAt?: string;
}


