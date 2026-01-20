package com.expensetracker.service;

import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense createExpense(Expense expense) {
        if (expense.getDescription() == null || expense.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Expense description cannot be empty");
        }
        if (expense.getAmount() == null || expense.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Expense amount must be greater than zero");
        }
        if (expense.getCategory() == null) {
            throw new IllegalArgumentException("Expense category is required");
        }
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense expenseDetails) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        
        if (expenseDetails.getDescription() != null) {
            expense.setDescription(expenseDetails.getDescription());
        }
        if (expenseDetails.getAmount() != null) {
            if (expenseDetails.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Expense amount must be greater than zero");
            }
            expense.setAmount(expenseDetails.getAmount());
        }
        if (expenseDetails.getCategory() != null) {
            expense.setCategory(expenseDetails.getCategory());
        }
        if (expenseDetails.getExpenseDate() != null) {
            expense.setExpenseDate(expenseDetails.getExpenseDate());
        }
        if (expenseDetails.getPaymentMethod() != null) {
            expense.setPaymentMethod(expenseDetails.getPaymentMethod());
        }
        if (expenseDetails.getNotes() != null) {
            expense.setNotes(expenseDetails.getNotes());
        }
        
        return expenseRepository.save(expense);
    }

    public boolean deleteExpense(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Expense> getExpensesByCategory(Expense.ExpenseCategory category) {
        return expenseRepository.findByCategory(category);
    }

    public List<Expense> getExpensesByDateRange(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findExpensesInDateRange(startDate, endDate);
    }

    public List<Expense> getExpensesByPaymentMethod(Expense.PaymentMethod paymentMethod) {
        return expenseRepository.findByPaymentMethod(paymentMethod);
    }

    public List<Expense> searchExpenses(String query) {
        return expenseRepository.searchExpenses(query);
    }

    public BigDecimal getTotalByCategory(Expense.ExpenseCategory category) {
        BigDecimal total = expenseRepository.getTotalByCategory(category);
        return total != null ? total : BigDecimal.ZERO;
    }

    public BigDecimal getTotalInDateRange(LocalDate startDate, LocalDate endDate) {
        BigDecimal total = expenseRepository.getTotalInDateRange(startDate, endDate);
        return total != null ? total : BigDecimal.ZERO;
    }

    public List<Expense> getExpensesByAmountRange(BigDecimal minAmount, BigDecimal maxAmount) {
        return expenseRepository.findByAmountRange(minAmount, maxAmount);
    }
}
