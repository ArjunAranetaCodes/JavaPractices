import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Workout } from '../models/workout';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {
  private apiUrl = 'http://localhost:8099/api/workouts';

  constructor(private http: HttpClient) {}

  getAllWorkouts(): Observable<Workout[]> {
    return this.http.get<Workout[]>(this.apiUrl);
  }

  getWorkoutById(id: number): Observable<Workout> {
    return this.http.get<Workout>(`${this.apiUrl}/${id}`);
  }

  searchWorkouts(query: string): Observable<Workout[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Workout[]>(`${this.apiUrl}/search`, { params });
  }

  getWorkoutsByType(type: string): Observable<Workout[]> {
    return this.http.get<Workout[]>(`${this.apiUrl}/type/${type}`);
  }

  getWorkoutsByCategory(category: string): Observable<Workout[]> {
    return this.http.get<Workout[]>(`${this.apiUrl}/category/${category}`);
  }

  getWorkoutsByDate(date: string): Observable<Workout[]> {
    return this.http.get<Workout[]>(`${this.apiUrl}/date/${date}`);
  }

  createWorkout(workout: Workout): Observable<Workout> {
    return this.http.post<Workout>(this.apiUrl, workout);
  }

  updateWorkout(id: number, workout: Workout): Observable<Workout> {
    return this.http.put<Workout>(`${this.apiUrl}/${id}`, workout);
  }

  deleteWorkout(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

