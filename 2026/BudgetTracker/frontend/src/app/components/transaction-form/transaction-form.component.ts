import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Transaction } from '../../models/transaction.model';

@Component({
  selector: 'app-transaction-form',
  templateUrl: './transaction-form.component.html',
  styleUrls: ['./transaction-form.component.css']
})
export class TransactionFormComponent implements OnInit {
  @Input() transaction!: Transaction;
  @Input() isEditMode = false;
  @Output() save = new EventEmitter<Transaction>();
  @Output() cancel = new EventEmitter<void>();

  form: Transaction = {
    type: 'EXPENSE',
    amount: 0,
    transactionDate: new Date().toISOString().slice(0, 10),
    category: 'Food',
    description: ''
  };

  incomeCategories = ['Salary', 'Freelance', 'Investment', 'Gift', 'Other'];
  expenseCategories = ['Food', 'Transport', 'Rent', 'Shopping', 'Utilities', 'Entertainment', 'Other'];

  ngOnInit(): void {
    if (this.transaction) {
      this.form = {
        ...this.transaction,
        amount: typeof this.transaction.amount === 'number'
          ? this.transaction.amount
          : Number(this.transaction.amount) || 0
      };
    }
  }

  get categories(): string[] {
    return (this.form.type || '').toUpperCase() === 'INCOME'
      ? this.incomeCategories
      : this.expenseCategories;
  }

  onSubmit(): void {
    if (this.isValid()) {
      this.save.emit(this.form);
    }
  }

  onCancel(): void {
    this.cancel.emit();
  }

  isValid(): boolean {
    return !!(
      (this.form.type === 'INCOME' || this.form.type === 'EXPENSE') &&
      (typeof this.form.amount === 'number' ? this.form.amount : Number(this.form.amount)) > 0 &&
      this.form.transactionDate
    );
  }
}
