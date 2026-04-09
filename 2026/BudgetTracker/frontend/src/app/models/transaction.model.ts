export interface Transaction {
  id?: number;
  type: string;  // INCOME | EXPENSE
  amount: number;
  transactionDate: string;
  category?: string;
  description?: string;
}
