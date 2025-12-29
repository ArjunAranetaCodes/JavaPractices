import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Goal } from '../models/goal';

@Injectable({
  providedIn: 'root'
})
export class GoalService {
  private apiUrl = 'http://localhost:8093/api/goals';

  constructor(private http: HttpClient) {}

  getAllGoals(): Observable<Goal[]> {
    return this.http.get<Goal[]>(this.apiUrl);
  }

  getGoalById(id: number): Observable<Goal> {
    return this.http.get<Goal>(`${this.apiUrl}/${id}`);
  }

  searchGoals(query: string): Observable<Goal[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Goal[]>(`${this.apiUrl}/search`, { params });
  }

  getGoalsByStatus(status: string): Observable<Goal[]> {
    return this.http.get<Goal[]>(`${this.apiUrl}/status/${status}`);
  }

  getGoalsByCategory(category: string): Observable<Goal[]> {
    return this.http.get<Goal[]>(`${this.apiUrl}/category/${category}`);
  }

  getGoalsByPriority(priority: string): Observable<Goal[]> {
    return this.http.get<Goal[]>(`${this.apiUrl}/priority/${priority}`);
  }

  createGoal(goal: Goal): Observable<Goal> {
    return this.http.post<Goal>(this.apiUrl, goal);
  }

  updateGoal(id: number, goal: Goal): Observable<Goal> {
    return this.http.put<Goal>(`${this.apiUrl}/${id}`, goal);
  }

  updateProgress(id: number, progress: number): Observable<Goal> {
    return this.http.put<Goal>(`${this.apiUrl}/${id}/progress`, progress);
  }

  completeGoal(id: number): Observable<Goal> {
    return this.http.put<Goal>(`${this.apiUrl}/${id}/complete`, {});
  }

  deleteGoal(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}


