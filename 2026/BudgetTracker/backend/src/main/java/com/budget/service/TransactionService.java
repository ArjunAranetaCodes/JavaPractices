package com.budget.service;

import com.budget.model.Transaction;
import com.budget.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAll() {
        return repository.findAll();
    }

    public Transaction getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }

    public List<Transaction> getByType(String type) {
        if (type == null || type.isBlank()) return getAll();
        return repository.findByTypeIgnoreCase(type.trim());
    }

    public List<Transaction> getByCategory(String category) {
        if (category == null || category.isBlank()) return getAll();
        return repository.findByCategoryIgnoreCase(category.trim());
    }

    public List<Transaction> getByDateRange(LocalDate start, LocalDate end) {
        if (start == null || end == null) return getAll();
        return repository.findByTransactionDateBetween(start, end);
    }

    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }

    public Transaction update(Long id, Transaction data) {
        Transaction existing = getById(id);
        existing.setType(data.getType());
        existing.setAmount(data.getAmount());
        existing.setTransactionDate(data.getTransactionDate());
        existing.setCategory(data.getCategory());
        existing.setDescription(data.getDescription());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Transaction existing = getById(id);
        repository.delete(existing);
    }
}
