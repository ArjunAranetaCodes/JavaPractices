export interface Movie {
  id?: number;
  title: string;
  director?: string;
  genre?: string;
  year?: number;
  runtime?: number;
  rating?: number;
  status?: 'WATCHED' | 'UNWATCHED';
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}

