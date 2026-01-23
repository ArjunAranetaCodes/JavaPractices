import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Expense, ExpenseCategory, PaymentMethod } from '../../models/expense.model';
import { ExpenseService } from '../../services/expense.service';

@Component({
  selector: 'app-expense-form',
  templateUrl: './expense-form.component.html',
  styleUrls: ['./expense-form.component.css']
})
export class ExpenseFormComponent implements OnInit {
  expense: Expense = {
    description: '',
    amount: 0,
    category: ExpenseCategory.OTHER,
    expenseDate: new Date().toISOString().split('T')[0],
    paymentMethod: PaymentMethod.CASH,
    notes: ''
  };

  isEditMode: boolean = false;
  expenseId?: number;

  categoryOptions = Object.values(ExpenseCategory);
  paymentMethodOptions = Object.values(PaymentMethod);

  constructor(
    private expenseService: ExpenseService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.expenseId = +params['id'];
        this.isEditMode = true;
        this.loadExpense();
      }
    });
  }

  loadExpense(): void {
    if (this.expenseId) {
      this.expenseService.getExpenseById(this.expenseId).subscribe({
        next: (expense) => {
          this.expense = expense;
          // Format date for input field
          if (expense.expenseDate) {
            this.expense.expenseDate = expense.expenseDate.split('T')[0];
          }
        },
        error: (error) => {
          console.error('Error loading expense:', error);
          this.router.navigate(['/expenses']);
        }
      });
    }
  }

  onSubmit(): void {
    if (!this.expense.description || this.expense.description.trim() === '') {
      alert('Expense description is required');
      return;
    }

    if (!this.expense.amount || this.expense.amount <= 0) {
      alert('Expense amount must be greater than zero');
      return;
    }

    if (this.isEditMode && this.expenseId) {
      this.expenseService.updateExpense(this.expenseId, this.expense).subscribe({
        next: () => {
          this.router.navigate(['/expenses']);
        },
        error: (error) => {
          console.error('Error updating expense:', error);
          alert('Error updating expense');
        }
      });
    } else {
      this.expenseService.createExpense(this.expense).subscribe({
        next: () => {
          this.router.navigate(['/expenses']);
        },
        error: (error) => {
          console.error('Error creating expense:', error);
          alert('Error creating expense');
        }
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/expenses']);
  }
}
