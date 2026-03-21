import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reminder } from '../models/reminder';

@Injectable({
  providedIn: 'root'
})
export class ReminderService {
  private apiUrl = 'http://localhost:8096/api/reminders';

  constructor(private http: HttpClient) {}

  getAllReminders(): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(this.apiUrl);
  }

  getReminderById(id: number): Observable<Reminder> {
    return this.http.get<Reminder>(`${this.apiUrl}/${id}`);
  }

  searchReminders(query: string): Observable<Reminder[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Reminder[]>(`${this.apiUrl}/search`, { params });
  }

  getRemindersByStatus(status: string): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.apiUrl}/status/${status}`);
  }

  getRemindersByCategory(category: string): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.apiUrl}/category/${category}`);
  }

  getRemindersByPriority(priority: string): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.apiUrl}/priority/${priority}`);
  }

  getUpcomingReminders(): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.apiUrl}/upcoming`);
  }

  getOverdueReminders(): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.apiUrl}/overdue`);
  }

  createReminder(reminder: Reminder): Observable<Reminder> {
    return this.http.post<Reminder>(this.apiUrl, reminder);
  }

  updateReminder(id: number, reminder: Reminder): Observable<Reminder> {
    return this.http.put<Reminder>(`${this.apiUrl}/${id}`, reminder);
  }

  markAsCompleted(id: number): Observable<Reminder> {
    return this.http.put<Reminder>(`${this.apiUrl}/${id}/complete`, {});
  }

  deleteReminder(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}


