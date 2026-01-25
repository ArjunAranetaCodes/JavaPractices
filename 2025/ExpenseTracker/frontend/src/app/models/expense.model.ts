export interface Expense {
  id?: number;
  description: string;
  amount: number;
  category: ExpenseCategory;
  expenseDate: string;
  paymentMethod?: PaymentMethod;
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}

export enum ExpenseCategory {
  FOOD = 'FOOD',
  TRANSPORTATION = 'TRANSPORTATION',
  SHOPPING = 'SHOPPING',
  BILLS = 'BILLS',
  ENTERTAINMENT = 'ENTERTAINMENT',
  HEALTH = 'HEALTH',
  EDUCATION = 'EDUCATION',
  TRAVEL = 'TRAVEL',
  OTHER = 'OTHER'
}

export enum PaymentMethod {
  CASH = 'CASH',
  CREDIT_CARD = 'CREDIT_CARD',
  DEBIT_CARD = 'DEBIT_CARD',
  BANK_TRANSFER = 'BANK_TRANSFER',
  DIGITAL_WALLET = 'DIGITAL_WALLET',
  OTHER = 'OTHER'
}
