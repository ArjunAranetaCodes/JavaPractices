import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private apiUrl = 'http://localhost:8091/api/movies';

  constructor(private http: HttpClient) {}

  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.apiUrl);
  }

  getMovieById(id: number): Observable<Movie> {
    return this.http.get<Movie>(`${this.apiUrl}/${id}`);
  }

  searchMovies(query: string): Observable<Movie[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Movie[]>(`${this.apiUrl}/search`, { params });
  }

  getMoviesByStatus(status: string): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.apiUrl}/status/${status}`);
  }

  getMoviesByGenre(genre: string): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.apiUrl}/genre/${genre}`);
  }

  createMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.apiUrl, movie);
  }

  updateMovie(id: number, movie: Movie): Observable<Movie> {
    return this.http.put<Movie>(`${this.apiUrl}/${id}`, movie);
  }

  toggleMovieStatus(id: number): Observable<Movie> {
    return this.http.put<Movie>(`${this.apiUrl}/${id}/toggle`, {});
  }

  deleteMovie(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

