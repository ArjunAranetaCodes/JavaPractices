import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private apiUrl = 'http://localhost:8090/api/items';

  constructor(private http: HttpClient) {}

  getAllItems(): Observable<Item[]> {
    return this.http.get<Item[]>(this.apiUrl);
  }

  getItemById(id: number): Observable<Item> {
    return this.http.get<Item>(`${this.apiUrl}/${id}`);
  }

  searchItems(query: string): Observable<Item[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Item[]>(`${this.apiUrl}/search`, { params });
  }

  getItemsByStatus(status: string): Observable<Item[]> {
    return this.http.get<Item[]>(`${this.apiUrl}/status/${status}`);
  }

  getItemsByCategory(category: string): Observable<Item[]> {
    return this.http.get<Item[]>(`${this.apiUrl}/category/${category}`);
  }

  createItem(item: Item): Observable<Item> {
    return this.http.post<Item>(this.apiUrl, item);
  }

  updateItem(id: number, item: Item): Observable<Item> {
    return this.http.put<Item>(`${this.apiUrl}/${id}`, item);
  }

  toggleItemStatus(id: number): Observable<Item> {
    return this.http.put<Item>(`${this.apiUrl}/${id}/toggle`, {});
  }

  deleteItem(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

