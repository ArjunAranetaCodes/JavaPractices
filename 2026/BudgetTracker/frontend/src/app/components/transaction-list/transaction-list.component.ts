import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../models/transaction.model';
import { TransactionService } from '../../services/transaction.service';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {
  transactions: Transaction[] = [];
  filtered: Transaction[] = [];
  selectedType = 'all';
  selectedCategory = 'all';
  categories: string[] = ['all', 'Salary', 'Food', 'Transport', 'Rent', 'Shopping', 'Utilities', 'Other'];
  showModal = false;
  isEditMode = false;
  editingTransaction: Transaction | null = null;

  constructor(private service: TransactionService) {}

  ngOnInit(): void {
    this.loadTransactions();
  }

  loadTransactions(): void {
    this.service.getAll().subscribe({
      next: (data) => {
        this.transactions = data;
        const cats = new Set(data.map(t => t.category).filter(Boolean));
        if (cats.size > 0) {
          this.categories = ['all', ...Array.from(cats).sort()];
        }
        this.applyFilters();
      },
      error: (err) => console.error('Error loading transactions', err)
    });
  }

  applyFilters(): void {
    let result = [...this.transactions];
    if (this.selectedType !== 'all') {
      result = result.filter(t => (t.type || '').toUpperCase() === this.selectedType.toUpperCase());
    }
    if (this.selectedCategory !== 'all') {
      result = result.filter(t => (t.category || '').toLowerCase() === this.selectedCategory.toLowerCase());
    }
    this.filtered = result;
  }

  onTypeChange(): void {
    this.applyFilters();
  }

  onCategoryChange(): void {
    this.applyFilters();
  }

  totalIncome(): number {
    return this.filtered
      .filter(t => (t.type || '').toUpperCase() === 'INCOME')
      .reduce((sum, t) => sum + (typeof t.amount === 'number' ? t.amount : Number(t.amount) || 0), 0);
  }

  totalExpense(): number {
    return this.filtered
      .filter(t => (t.type || '').toUpperCase() === 'EXPENSE')
      .reduce((sum, t) => sum + (typeof t.amount === 'number' ? t.amount : Number(t.amount) || 0), 0);
  }

  balance(): number {
    return this.totalIncome() - this.totalExpense();
  }

  formatAmount(amount: number | string): string {
    const n = typeof amount === 'number' ? amount : Number(amount) || 0;
    return n.toFixed(2);
  }

  openAddModal(type: string): void {
    const today = new Date().toISOString().slice(0, 10);
    this.isEditMode = false;
    this.editingTransaction = {
      type: type.toUpperCase(),
      amount: 0,
      transactionDate: today,
      category: type.toUpperCase() === 'INCOME' ? 'Salary' : 'Food',
      description: ''
    };
    this.showModal = true;
  }

  openEditModal(txn: Transaction): void {
    this.isEditMode = true;
    this.editingTransaction = {
      ...txn,
      amount: typeof txn.amount === 'number' ? txn.amount : Number(txn.amount) || 0
    };
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.editingTransaction = null;
    this.isEditMode = false;
  }

  saveTransaction(txn: Transaction): void {
    const payload = {
      ...txn,
      amount: typeof txn.amount === 'number' ? txn.amount : Number(txn.amount) || 0
    };
    if (this.isEditMode && txn.id) {
      this.service.update(txn.id, payload).subscribe({
        next: () => {
          this.loadTransactions();
          this.closeModal();
        },
        error: (err) => console.error('Error updating transaction', err)
      });
    } else {
      this.service.create(payload).subscribe({
        next: () => {
          this.loadTransactions();
          this.closeModal();
        },
        error: (err) => console.error('Error creating transaction', err)
      });
    }
  }

  deleteTransaction(id: number): void {
    if (!confirm('Delete this transaction?')) return;
    this.service.delete(id).subscribe({
      next: () => this.loadTransactions(),
      error: (err) => console.error('Error deleting transaction', err)
    });
  }
}
