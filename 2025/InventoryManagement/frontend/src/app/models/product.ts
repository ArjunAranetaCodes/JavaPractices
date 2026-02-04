export interface Product {
  id?: number;
  name: string;
  description?: string;
  sku?: string;
  category?: 'ELECTRONICS' | 'CLOTHING' | 'FOOD' | 'BOOKS' | 'TOYS' | 'SPORTS' | 'HOME' | 'BEAUTY' | 'OTHER';
  price?: number;
  quantity?: number;
  supplier?: string;
  location?: string;
  minStockLevel?: number;
  createdAt?: string;
  updatedAt?: string;
}
