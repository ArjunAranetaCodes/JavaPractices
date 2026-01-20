export interface Customer {
  id?: number;
  firstName: string;
  lastName: string;
  email?: string;
  phone?: string;
  company?: string;
  industry?: 'TECHNOLOGY' | 'HEALTHCARE' | 'FINANCE' | 'RETAIL' | 'EDUCATION' | 'MANUFACTURING' | 'CONSULTING' | 'OTHER';
  status?: 'LEAD' | 'ACTIVE' | 'INACTIVE' | 'CLOSED';
  address?: string;
  city?: string;
  state?: string;
  zipCode?: string;
  country?: string;
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}
