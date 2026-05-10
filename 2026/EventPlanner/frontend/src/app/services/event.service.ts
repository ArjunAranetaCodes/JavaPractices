import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EventItem } from '../models/event.model';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private apiUrl = 'http://localhost:8094/api/events';

  constructor(private http: HttpClient) {}

  getAll(): Observable<EventItem[]> {
    return this.http.get<EventItem[]>(this.apiUrl);
  }

  getById(id: number): Observable<EventItem> {
    return this.http.get<EventItem>(`${this.apiUrl}/${id}`);
  }

  getByCategory(category: string): Observable<EventItem[]> {
    return this.http.get<EventItem[]>(`${this.apiUrl}/category/${encodeURIComponent(category)}`);
  }

  getByStatus(status: string): Observable<EventItem[]> {
    return this.http.get<EventItem[]>(`${this.apiUrl}/status/${encodeURIComponent(status)}`);
  }

  getByRange(start: string, end: string): Observable<EventItem[]> {
    return this.http.get<EventItem[]>(`${this.apiUrl}/range?start=${encodeURIComponent(start)}&end=${encodeURIComponent(end)}`);
  }

  search(q: string): Observable<EventItem[]> {
    return this.http.get<EventItem[]>(`${this.apiUrl}/search?q=${encodeURIComponent(q)}`);
  }

  create(event: EventItem): Observable<EventItem> {
    return this.http.post<EventItem>(this.apiUrl, event);
  }

  update(id: number, event: EventItem): Observable<EventItem> {
    return this.http.put<EventItem>(`${this.apiUrl}/${id}`, event);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
