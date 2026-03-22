package com.shoppinglist.service;

import com.shoppinglist.model.ShoppingItem;
import com.shoppinglist.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingItemService {

    @Autowired
    private ShoppingItemRepository shoppingItemRepository;

    public List<ShoppingItem> getAllItems() {
        return shoppingItemRepository.findAll();
    }

    public ShoppingItem getItemById(Long id) {
        Optional<ShoppingItem> item = shoppingItemRepository.findById(id);
        return item.orElse(null);
    }

    public List<ShoppingItem> searchItems(String query) {
        return shoppingItemRepository.searchByName(query);
    }

    public List<ShoppingItem> getItemsByCategory(String category) {
        return shoppingItemRepository.findByCategory(category);
    }

    public List<ShoppingItem> getItemsByCompleted(Boolean completed) {
        return shoppingItemRepository.findByCompleted(completed);
    }

    public List<ShoppingItem> getItemsByPriority(ShoppingItem.Priority priority) {
        return shoppingItemRepository.findByPriority(priority);
    }

    public ShoppingItem createItem(ShoppingItem item) {
        return shoppingItemRepository.save(item);
    }

    public ShoppingItem updateItem(Long id, ShoppingItem itemDetails) {
        Optional<ShoppingItem> optionalItem = shoppingItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            ShoppingItem item = optionalItem.get();
            item.setName(itemDetails.getName());
            item.setQuantity(itemDetails.getQuantity());
            item.setUnit(itemDetails.getUnit());
            item.setPriority(itemDetails.getPriority());
            item.setCompleted(itemDetails.getCompleted());
            item.setCategory(itemDetails.getCategory());
            item.setNotes(itemDetails.getNotes());
            return shoppingItemRepository.save(item);
        }
        return null;
    }

    public ShoppingItem toggleCompleted(Long id) {
        Optional<ShoppingItem> optionalItem = shoppingItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            ShoppingItem item = optionalItem.get();
            item.setCompleted(!item.getCompleted());
            return shoppingItemRepository.save(item);
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        if (shoppingItemRepository.existsById(id)) {
            shoppingItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}







