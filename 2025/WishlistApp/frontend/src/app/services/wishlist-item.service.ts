import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WishlistItem } from '../models/wishlist-item';

@Injectable({
  providedIn: 'root'
})
export class WishlistItemService {
  private apiUrl = 'http://localhost:8095/api/items';

  constructor(private http: HttpClient) {}

  getAllItems(): Observable<WishlistItem[]> {
    return this.http.get<WishlistItem[]>(this.apiUrl);
  }

  getItemById(id: number): Observable<WishlistItem> {
    return this.http.get<WishlistItem>(`${this.apiUrl}/${id}`);
  }

  searchItems(query: string): Observable<WishlistItem[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<WishlistItem[]>(`${this.apiUrl}/search`, { params });
  }

  getItemsByStatus(status: string): Observable<WishlistItem[]> {
    return this.http.get<WishlistItem[]>(`${this.apiUrl}/status/${status}`);
  }

  getItemsByCategory(category: string): Observable<WishlistItem[]> {
    return this.http.get<WishlistItem[]>(`${this.apiUrl}/category/${category}`);
  }

  getItemsByPriority(priority: string): Observable<WishlistItem[]> {
    return this.http.get<WishlistItem[]>(`${this.apiUrl}/priority/${priority}`);
  }

  createItem(item: WishlistItem): Observable<WishlistItem> {
    return this.http.post<WishlistItem>(this.apiUrl, item);
  }

  updateItem(id: number, item: WishlistItem): Observable<WishlistItem> {
    return this.http.put<WishlistItem>(`${this.apiUrl}/${id}`, item);
  }

  markAsPurchased(id: number): Observable<WishlistItem> {
    return this.http.put<WishlistItem>(`${this.apiUrl}/${id}/purchase`, {});
  }

  deleteItem(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

