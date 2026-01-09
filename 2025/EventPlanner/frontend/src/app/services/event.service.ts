import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Event } from '../models/event';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private apiUrl = 'http://localhost:8098/api/events';

  constructor(private http: HttpClient) {}

  getAllEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(this.apiUrl);
  }

  getEventById(id: number): Observable<Event> {
    return this.http.get<Event>(`${this.apiUrl}/${id}`);
  }

  searchEvents(query: string): Observable<Event[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Event[]>(`${this.apiUrl}/search`, { params });
  }

  getEventsByCategory(category: string): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/category/${category}`);
  }

  getEventsByStatus(status: string): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/status/${status}`);
  }

  getEventsByPriority(priority: string): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/priority/${priority}`);
  }

  getEventsByDate(date: string): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/date/${date}`);
  }

  getUpcomingEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/upcoming`);
  }

  createEvent(event: Event): Observable<Event> {
    return this.http.post<Event>(this.apiUrl, event);
  }

  updateEvent(id: number, event: Event): Observable<Event> {
    return this.http.put<Event>(`${this.apiUrl}/${id}`, event);
  }

  deleteEvent(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

