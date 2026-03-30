package com.wishlist.controller;

import com.wishlist.model.WishlistItem;
import com.wishlist.service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:4200")
public class WishlistItemController {

    @Autowired
    private WishlistItemService wishlistItemService;

    @GetMapping
    public ResponseEntity<List<WishlistItem>> getAllItems() {
        List<WishlistItem> items = wishlistItemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishlistItem> getItemById(@PathVariable Long id) {
        WishlistItem item = wishlistItemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<WishlistItem>> searchItems(@RequestParam String query) {
        List<WishlistItem> items = wishlistItemService.searchItems(query);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<WishlistItem>> getItemsByStatus(@PathVariable String status) {
        try {
            WishlistItem.Status itemStatus = WishlistItem.Status.valueOf(status.toUpperCase());
            List<WishlistItem> items = wishlistItemService.getItemsByStatus(itemStatus);
            return ResponseEntity.ok(items);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<WishlistItem>> getItemsByCategory(@PathVariable String category) {
        List<WishlistItem> items = wishlistItemService.getItemsByCategory(category);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<WishlistItem>> getItemsByPriority(@PathVariable String priority) {
        try {
            WishlistItem.Priority itemPriority = WishlistItem.Priority.valueOf(priority.toUpperCase());
            List<WishlistItem> items = wishlistItemService.getItemsByPriority(itemPriority);
            return ResponseEntity.ok(items);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<WishlistItem> createItem(@RequestBody WishlistItem item) {
        WishlistItem created = wishlistItemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WishlistItem> updateItem(@PathVariable Long id, @RequestBody WishlistItem item) {
        WishlistItem updated = wishlistItemService.updateItem(id, item);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/purchase")
    public ResponseEntity<WishlistItem> markAsPurchased(@PathVariable Long id) {
        WishlistItem updated = wishlistItemService.markAsPurchased(id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean deleted = wishlistItemService.deleteItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

