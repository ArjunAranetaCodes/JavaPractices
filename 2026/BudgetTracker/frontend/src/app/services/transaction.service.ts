import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../models/transaction.model';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private apiUrl = 'http://localhost:8085/api/transactions';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.apiUrl);
  }

  getById(id: number): Observable<Transaction> {
    return this.http.get<Transaction>(`${this.apiUrl}/${id}`);
  }

  getByType(type: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.apiUrl}/type/${encodeURIComponent(type)}`);
  }

  getByCategory(category: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.apiUrl}/category/${encodeURIComponent(category)}`);
  }

  getByDateRange(start: string, end: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.apiUrl}/range?start=${start}&end=${end}`);
  }

  create(txn: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(this.apiUrl, txn);
  }

  update(id: number, txn: Transaction): Observable<Transaction> {
    return this.http.put<Transaction>(`${this.apiUrl}/${id}`, txn);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
