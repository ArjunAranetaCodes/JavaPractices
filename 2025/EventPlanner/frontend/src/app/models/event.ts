export interface Event {
  id?: number;
  title: string;
  description?: string;
  eventDate: string; // ISO date string (YYYY-MM-DD)
  eventTime?: string; // Time string (HH:mm)
  location?: string;
  category?: 'MEETING' | 'BIRTHDAY' | 'WEDDING' | 'CONFERENCE' | 'WORKSHOP' | 'CONCERT' | 'SPORTS' | 'HOLIDAY' | 'ANNIVERSARY' | 'PARTY' | 'SEMINAR' | 'EXHIBITION' | 'OTHER';
  status?: 'UPCOMING' | 'IN_PROGRESS' | 'COMPLETED' | 'CANCELLED';
  priority?: 'HIGH' | 'MEDIUM' | 'LOW';
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}

