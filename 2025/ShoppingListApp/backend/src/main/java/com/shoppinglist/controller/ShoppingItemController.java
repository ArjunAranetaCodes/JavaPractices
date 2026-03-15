package com.shoppinglist.controller;

import com.shoppinglist.model.ShoppingItem;
import com.shoppinglist.service.ShoppingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:4200")
public class ShoppingItemController {

    @Autowired
    private ShoppingItemService shoppingItemService;

    @GetMapping
    public ResponseEntity<List<ShoppingItem>> getAllItems() {
        List<ShoppingItem> items = shoppingItemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingItem> getItemById(@PathVariable Long id) {
        ShoppingItem item = shoppingItemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ShoppingItem>> searchItems(@RequestParam String query) {
        List<ShoppingItem> items = shoppingItemService.searchItems(query);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/status/{completed}")
    public ResponseEntity<List<ShoppingItem>> getItemsByStatus(@PathVariable Boolean completed) {
        List<ShoppingItem> items = shoppingItemService.getItemsByCompleted(completed);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ShoppingItem>> getItemsByCategory(@PathVariable String category) {
        List<ShoppingItem> items = shoppingItemService.getItemsByCategory(category);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<ShoppingItem>> getItemsByPriority(@PathVariable String priority) {
        try {
            ShoppingItem.Priority itemPriority = ShoppingItem.Priority.valueOf(priority.toUpperCase());
            List<ShoppingItem> items = shoppingItemService.getItemsByPriority(itemPriority);
            return ResponseEntity.ok(items);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ShoppingItem> createItem(@RequestBody ShoppingItem item) {
        ShoppingItem created = shoppingItemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingItem> updateItem(@PathVariable Long id, @RequestBody ShoppingItem item) {
        ShoppingItem updated = shoppingItemService.updateItem(id, item);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/toggle")
    public ResponseEntity<ShoppingItem> toggleCompleted(@PathVariable Long id) {
        ShoppingItem updated = shoppingItemService.toggleCompleted(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean deleted = shoppingItemService.deleteItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}







