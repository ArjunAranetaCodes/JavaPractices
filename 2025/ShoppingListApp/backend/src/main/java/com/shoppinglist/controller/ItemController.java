package com.shoppinglist.controller;

import com.shoppinglist.model.Item;
import com.shoppinglist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItems(@RequestParam String query) {
        List<Item> items = itemService.searchItems(query);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Item>> getItemsByStatus(@PathVariable String status) {
        try {
            Item.Status itemStatus = Item.Status.valueOf(status.toUpperCase());
            List<Item> items = itemService.getItemsByStatus(itemStatus);
            return ResponseEntity.ok(items);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Item>> getItemsByCategory(@PathVariable String category) {
        List<Item> items = itemService.getItemsByCategory(category);
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item created = itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updated = itemService.updateItem(id, item);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/toggle")
    public ResponseEntity<Item> toggleItemStatus(@PathVariable Long id) {
        Item updated = itemService.toggleItemStatus(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean deleted = itemService.deleteItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

