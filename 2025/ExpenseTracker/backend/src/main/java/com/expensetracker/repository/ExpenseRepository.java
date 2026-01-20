package com.expensetracker.repository;

import com.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
    List<Expense> findByCategory(Expense.ExpenseCategory category);
    
    List<Expense> findByExpenseDate(LocalDate date);
    
    List<Expense> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);
    
    List<Expense> findByPaymentMethod(Expense.PaymentMethod paymentMethod);
    
    @Query("SELECT e FROM Expense e WHERE e.expenseDate >= :startDate AND e.expenseDate <= :endDate")
    List<Expense> findExpensesInDateRange(@Param("startDate") LocalDate startDate, 
                                          @Param("endDate") LocalDate endDate);
    
    @Query("SELECT e FROM Expense e WHERE " +
           "LOWER(e.description) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(e.notes) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Expense> searchExpenses(@Param("query") String query);
    
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.category = :category")
    BigDecimal getTotalByCategory(@Param("category") Expense.ExpenseCategory category);
    
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.expenseDate >= :startDate AND e.expenseDate <= :endDate")
    BigDecimal getTotalInDateRange(@Param("startDate") LocalDate startDate, 
                                    @Param("endDate") LocalDate endDate);
    
    @Query("SELECT e FROM Expense e WHERE e.amount >= :minAmount AND e.amount <= :maxAmount")
    List<Expense> findByAmountRange(@Param("minAmount") BigDecimal minAmount, 
                                    @Param("maxAmount") BigDecimal maxAmount);
}
