package com.expense.repository;

import com.expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT e FROM Expense e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Expense> searchByDescription(@Param("query") String query);

    List<Expense> findByCategory(String category);

    @Query("SELECT SUM(e.amount) FROM Expense e")
    BigDecimal getTotalAmount();
}

