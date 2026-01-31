import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Habit } from '../models/habit';

@Injectable({
  providedIn: 'root'
})
export class HabitService {
  private apiUrl = 'http://localhost:8092/api/habits';

  constructor(private http: HttpClient) {}

  getAllHabits(): Observable<Habit[]> {
    return this.http.get<Habit[]>(this.apiUrl);
  }

  getHabitById(id: number): Observable<Habit> {
    return this.http.get<Habit>(`${this.apiUrl}/${id}`);
  }

  searchHabits(query: string): Observable<Habit[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Habit[]>(`${this.apiUrl}/search`, { params });
  }

  getHabitsByCategory(category: string): Observable<Habit[]> {
    return this.http.get<Habit[]>(`${this.apiUrl}/category/${category}`);
  }

  getHabitsByStatus(status: string): Observable<Habit[]> {
    return this.http.get<Habit[]>(`${this.apiUrl}/status/${status}`);
  }

  createHabit(habit: Habit): Observable<Habit> {
    return this.http.post<Habit>(this.apiUrl, habit);
  }

  updateHabit(id: number, habit: Habit): Observable<Habit> {
    return this.http.put<Habit>(`${this.apiUrl}/${id}`, habit);
  }

  completeHabit(id: number): Observable<Habit> {
    return this.http.put<Habit>(`${this.apiUrl}/${id}/complete`, {});
  }

  resetHabitStreak(id: number): Observable<Habit> {
    return this.http.put<Habit>(`${this.apiUrl}/${id}/reset`, {});
  }

  deleteHabit(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

