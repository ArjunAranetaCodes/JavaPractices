import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bookmark } from '../models/bookmark.model';

@Injectable({
  providedIn: 'root'
})
export class BookmarkService {
  private apiUrl = 'http://localhost:8084/api/bookmarks';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Bookmark[]> {
    return this.http.get<Bookmark[]>(this.apiUrl);
  }

  getById(id: number): Observable<Bookmark> {
    return this.http.get<Bookmark>(`${this.apiUrl}/${id}`);
  }

  getByCategory(category: string): Observable<Bookmark[]> {
    return this.http.get<Bookmark[]>(`${this.apiUrl}/category/${encodeURIComponent(category)}`);
  }

  search(q: string): Observable<Bookmark[]> {
    return this.http.get<Bookmark[]>(`${this.apiUrl}/search?q=${encodeURIComponent(q)}`);
  }

  create(bookmark: Bookmark): Observable<Bookmark> {
    return this.http.post<Bookmark>(this.apiUrl, bookmark);
  }

  update(id: number, bookmark: Bookmark): Observable<Bookmark> {
    return this.http.put<Bookmark>(`${this.apiUrl}/${id}`, bookmark);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
