package com.grocery.service;

import com.grocery.model.GroceryItem;
import com.grocery.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repository;

    public GroceryItemService(GroceryItemRepository repository) {
        this.repository = repository;
    }

    public List<GroceryItem> getAll() {
        return repository.findAll();
    }

    public GroceryItem getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));
    }

    public List<GroceryItem> getByCategory(String category) {
        if (category == null || category.isBlank()) return getAll();
        return repository.findByCategoryIgnoreCase(category.trim());
    }

    public List<GroceryItem> getByPurchased(boolean purchased) {
        return repository.findByPurchased(purchased);
    }

    public List<GroceryItem> search(String term) {
        if (term == null || term.isBlank()) return getAll();
        return repository.findByNameContainingIgnoreCase(term.trim());
    }

    public GroceryItem create(GroceryItem item) {
        return repository.save(item);
    }

    public GroceryItem update(Long id, GroceryItem data) {
        GroceryItem existing = getById(id);
        existing.setName(data.getName());
        existing.setQuantity(data.getQuantity());
        existing.setUnit(data.getUnit());
        existing.setCategory(data.getCategory());
        existing.setPurchased(data.isPurchased());
        return repository.save(existing);
    }

    public void delete(Long id) {
        GroceryItem existing = getById(id);
        repository.delete(existing);
    }
}
