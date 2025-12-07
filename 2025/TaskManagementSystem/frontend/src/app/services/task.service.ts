import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task, TaskStatus, TaskPriority } from '../models/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'http://localhost:8084/api/tasks';

  constructor(private http: HttpClient) { }

  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl);
  }

  getTaskById(id: number): Observable<Task> {
    return this.http.get<Task>(`${this.apiUrl}/${id}`);
  }

  createTask(task: Task): Observable<Task> {
    return this.http.post<Task>(this.apiUrl, task);
  }

  updateTask(id: number, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.apiUrl}/${id}`, task);
  }

  deleteTask(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getTasksByStatus(status: TaskStatus): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/status/${status}`);
  }

  getTasksByPriority(priority: TaskPriority): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/priority/${priority}`);
  }

  getTasksByAssignedTo(assignedTo: string): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/assigned/${assignedTo}`);
  }

  getOverdueTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/overdue`);
  }

  searchTasks(query: string): Observable<Task[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Task[]>(`${this.apiUrl}/search`, { params });
  }

  updateTaskStatus(id: number, status: TaskStatus): Observable<Task> {
    const params = new HttpParams().set('status', status);
    return this.http.patch<Task>(`${this.apiUrl}/${id}/status`, null, { params });
  }
}

