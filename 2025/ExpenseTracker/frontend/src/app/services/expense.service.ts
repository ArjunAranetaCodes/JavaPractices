import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Expense, ExpenseCategory, PaymentMethod } from '../models/expense.model';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
  private apiUrl = 'http://localhost:8085/api/expenses';

  constructor(private http: HttpClient) { }

  getAllExpenses(): Observable<Expense[]> {
    return this.http.get<Expense[]>(this.apiUrl);
  }

  getExpenseById(id: number): Observable<Expense> {
    return this.http.get<Expense>(`${this.apiUrl}/${id}`);
  }

  createExpense(expense: Expense): Observable<Expense> {
    return this.http.post<Expense>(this.apiUrl, expense);
  }

  updateExpense(id: number, expense: Expense): Observable<Expense> {
    return this.http.put<Expense>(`${this.apiUrl}/${id}`, expense);
  }

  deleteExpense(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getExpensesByCategory(category: ExpenseCategory): Observable<Expense[]> {
    return this.http.get<Expense[]>(`${this.apiUrl}/category/${category}`);
  }

  getExpensesByDateRange(startDate: string, endDate: string): Observable<Expense[]> {
    const params = new HttpParams()
      .set('startDate', startDate)
      .set('endDate', endDate);
    return this.http.get<Expense[]>(`${this.apiUrl}/date-range`, { params });
  }

  getExpensesByPaymentMethod(paymentMethod: PaymentMethod): Observable<Expense[]> {
    return this.http.get<Expense[]>(`${this.apiUrl}/payment-method/${paymentMethod}`);
  }

  searchExpenses(query: string): Observable<Expense[]> {
    const params = new HttpParams().set('query', query);
    return this.http.get<Expense[]>(`${this.apiUrl}/search`, { params });
  }

  getTotalByCategory(category: ExpenseCategory): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/total/category/${category}`);
  }

  getTotalInDateRange(startDate: string, endDate: string): Observable<number> {
    const params = new HttpParams()
      .set('startDate', startDate)
      .set('endDate', endDate);
    return this.http.get<number>(`${this.apiUrl}/total/date-range`, { params });
  }
}
