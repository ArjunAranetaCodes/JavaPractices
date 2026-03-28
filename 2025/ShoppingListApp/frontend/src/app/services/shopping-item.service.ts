import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ShoppingItem } from '../models/shopping-item';

@Injectable({
  providedIn: 'root'
})
export class ShoppingItemService {
  private apiUrl = 'http://localhost:8097/api/items';

  constructor(private http: HttpClient) {}

  getAllItems(): Observable<ShoppingItem[]> {
    return this.http.get<ShoppingItem[]>(this.apiUrl);
  }

  getItemById(id: number): Observable<ShoppingItem> {
    return this.http.get<ShoppingItem>(`${this.apiUrl}/${id}`);
  }

  searchItems(query: string): Observable<ShoppingItem[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<ShoppingItem[]>(`${this.apiUrl}/search`, { params });
  }

  getItemsByStatus(completed: boolean): Observable<ShoppingItem[]> {
    return this.http.get<ShoppingItem[]>(`${this.apiUrl}/status/${completed}`);
  }

  getItemsByCategory(category: string): Observable<ShoppingItem[]> {
    return this.http.get<ShoppingItem[]>(`${this.apiUrl}/category/${category}`);
  }

  getItemsByPriority(priority: string): Observable<ShoppingItem[]> {
    return this.http.get<ShoppingItem[]>(`${this.apiUrl}/priority/${priority}`);
  }

  createItem(item: ShoppingItem): Observable<ShoppingItem> {
    return this.http.post<ShoppingItem>(this.apiUrl, item);
  }

  updateItem(id: number, item: ShoppingItem): Observable<ShoppingItem> {
    return this.http.put<ShoppingItem>(`${this.apiUrl}/${id}`, item);
  }

  toggleCompleted(id: number): Observable<ShoppingItem> {
    return this.http.put<ShoppingItem>(`${this.apiUrl}/${id}/toggle`, {});
  }

  deleteItem(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}







