export interface Project {
  id?: number;
  name: string;
  description?: string;
  status?: 'PLANNING' | 'IN_PROGRESS' | 'ON_HOLD' | 'COMPLETED' | 'CANCELLED';
  priority?: 'LOW' | 'MEDIUM' | 'HIGH' | 'CRITICAL';
  category?: 'WEB_DEVELOPMENT' | 'MOBILE_APP' | 'MARKETING' | 'RESEARCH' | 'DESIGN' | 'INFRASTRUCTURE' | 'OTHER';
  startDate?: string; // ISO date string (YYYY-MM-DD)
  endDate?: string; // ISO date string (YYYY-MM-DD)
  progress?: number; // 0-100
  budget?: number;
  teamMembers?: string;
  projectManager?: string;
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}

