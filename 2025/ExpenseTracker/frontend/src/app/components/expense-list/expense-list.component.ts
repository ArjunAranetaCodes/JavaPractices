import { Component, OnInit } from '@angular/core';
import { Expense, ExpenseCategory, PaymentMethod } from '../../models/expense.model';
import { ExpenseService } from '../../services/expense.service';

@Component({
  selector: 'app-expense-list',
  templateUrl: './expense-list.component.html',
  styleUrls: ['./expense-list.component.css']
})
export class ExpenseListComponent implements OnInit {
  expenses: Expense[] = [];
  filteredExpenses: Expense[] = [];
  searchQuery: string = '';
  categoryFilter: string = 'ALL';
  paymentMethodFilter: string = 'ALL';
  totalAmount: number = 0;

  constructor(private expenseService: ExpenseService) { }

  ngOnInit(): void {
    this.loadExpenses();
  }

  loadExpenses(): void {
    this.expenseService.getAllExpenses().subscribe({
      next: (expenses) => {
        this.expenses = expenses;
        this.applyFilters();
        this.calculateTotal();
      },
      error: (error) => {
        console.error('Error loading expenses:', error);
      }
    });
  }

  applyFilters(): void {
    let filtered = [...this.expenses];

    // Category filter
    if (this.categoryFilter !== 'ALL') {
      filtered = filtered.filter(expense => expense.category === this.categoryFilter);
    }

    // Payment method filter
    if (this.paymentMethodFilter !== 'ALL') {
      filtered = filtered.filter(expense => expense.paymentMethod === this.paymentMethodFilter);
    }

    // Search filter
    if (this.searchQuery.trim()) {
      const query = this.searchQuery.toLowerCase();
      filtered = filtered.filter(expense =>
        expense.description.toLowerCase().includes(query) ||
        (expense.notes && expense.notes.toLowerCase().includes(query))
      );
    }

    this.filteredExpenses = filtered;
    this.calculateTotal();
  }

  calculateTotal(): void {
    this.totalAmount = this.filteredExpenses.reduce((sum, expense) => sum + expense.amount, 0);
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onCategoryFilterChange(): void {
    this.applyFilters();
  }

  onPaymentMethodFilterChange(): void {
    this.applyFilters();
  }

  deleteExpense(id: number): void {
    if (confirm('Are you sure you want to delete this expense?')) {
      this.expenseService.deleteExpense(id).subscribe({
        next: () => {
          this.loadExpenses();
        },
        error: (error) => {
          console.error('Error deleting expense:', error);
        }
      });
    }
  }

  getCategoryClass(category: ExpenseCategory): string {
    const categoryMap: { [key: string]: string } = {
      'FOOD': 'category-food',
      'TRANSPORTATION': 'category-transportation',
      'SHOPPING': 'category-shopping',
      'BILLS': 'category-bills',
      'ENTERTAINMENT': 'category-entertainment',
      'HEALTH': 'category-health',
      'EDUCATION': 'category-education',
      'TRAVEL': 'category-travel',
      'OTHER': 'category-other'
    };
    return categoryMap[category] || 'category-other';
  }

  getCategoryOptions(): string[] {
    return Object.values(ExpenseCategory);
  }

  getPaymentMethodOptions(): string[] {
    return Object.values(PaymentMethod);
  }
}
