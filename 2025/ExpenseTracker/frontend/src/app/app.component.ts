import { Component, OnInit } from '@angular/core';
import { ExpenseService } from './services/expense.service';
import { Expense } from './models/expense';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  expenses: Expense[] = [];
  filteredExpenses: Expense[] = [];
  searchTerm: string = '';
  selectedCategory: string = '';
  totalExpenses: number = 0;
  categories: string[] = ['Food', 'Transport', 'Shopping', 'Bills', 'Entertainment', 'Health', 'Education', 'Other'];
  showModal: boolean = false;
  editingExpense: Expense | null = null;
  newExpense: Expense = {
    description: '',
    amount: 0,
    category: '',
    expenseDate: new Date().toISOString().split('T')[0]
  };

  constructor(private expenseService: ExpenseService) {}

  ngOnInit() {
    this.loadExpenses();
    this.loadTotal();
  }

  loadExpenses() {
    this.expenseService.getAllExpenses().subscribe(
      (expenses) => {
        this.expenses = expenses;
        this.applyFilters();
        this.loadTotal();
      },
      (error) => {
        console.error('Error loading expenses:', error);
      }
    );
  }

  loadTotal() {
    this.expenseService.getTotalExpenses().subscribe(
      (total) => {
        this.totalExpenses = total;
      },
      (error) => {
        console.error('Error loading total:', error);
      }
    );
  }

  applyFilters() {
    let filtered = [...this.expenses];

    // Apply search filter
    if (this.searchTerm.trim() !== '') {
      this.expenseService.searchExpenses(this.searchTerm).subscribe(
        (searchedExpenses) => {
          filtered = searchedExpenses;
          this.applyCategoryFilter(filtered);
        },
        (error) => {
          console.error('Error searching expenses:', error);
        }
      );
    } else {
      this.applyCategoryFilter(filtered);
    }
  }

  applyCategoryFilter(expenses: Expense[]) {
    if (this.selectedCategory && this.selectedCategory !== '') {
      this.filteredExpenses = expenses.filter(expense => expense.category === this.selectedCategory);
    } else {
      this.filteredExpenses = expenses;
    }
  }

  onSearchChange() {
    this.applyFilters();
  }

  onCategoryChange() {
    this.applyFilters();
  }

  clearFilters() {
    this.searchTerm = '';
    this.selectedCategory = '';
    this.applyFilters();
  }

  openModal(expense?: Expense) {
    if (expense) {
      this.editingExpense = { ...expense };
      this.newExpense = { 
        ...expense,
        expenseDate: expense.expenseDate ? expense.expenseDate.split('T')[0] : new Date().toISOString().split('T')[0]
      };
    } else {
      this.editingExpense = null;
      this.newExpense = {
        description: '',
        amount: 0,
        category: '',
        expenseDate: new Date().toISOString().split('T')[0]
      };
    }
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.editingExpense = null;
  }

  saveExpense() {
    if (this.editingExpense) {
      this.updateExpense();
    } else {
      this.createExpense();
    }
  }

  createExpense() {
    this.expenseService.createExpense(this.newExpense).subscribe(
      (expense) => {
        this.expenses.push(expense);
        this.applyFilters();
        this.loadTotal();
        this.closeModal();
      },
      (error) => {
        console.error('Error creating expense:', error);
      }
    );
  }

  updateExpense() {
    if (this.editingExpense && this.editingExpense.id) {
      this.expenseService.updateExpense(this.editingExpense.id, this.newExpense).subscribe(
        (expense) => {
          const index = this.expenses.findIndex(e => e.id === expense.id);
          if (index !== -1) {
            this.expenses[index] = expense;
          }
          this.applyFilters();
          this.loadTotal();
          this.closeModal();
        },
        (error) => {
          console.error('Error updating expense:', error);
        }
      );
    }
  }

  deleteExpense(id: number) {
    if (confirm('Are you sure you want to delete this expense?')) {
      this.expenseService.deleteExpense(id).subscribe(
        () => {
          this.expenses = this.expenses.filter(e => e.id !== id);
          this.applyFilters();
          this.loadTotal();
        },
        (error) => {
          console.error('Error deleting expense:', error);
        }
      );
    }
  }

  getTotalByCategory(category: string): number {
    return this.expenses
      .filter(e => e.category === category)
      .reduce((sum, e) => sum + e.amount, 0);
  }
}

